package com.wisecoders.dbschema.dbf;

import com.wisecoders.dbschema.dbf.io.H2Loader;
import com.wisecoders.dbschema.dbf.io.H2Writer;
import com.wisecoders.dbschema.dbf.schema.Table;
import com.linuxense.javadbf.DBFReader;
import org.h2.jdbc.JdbcConnection;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.charset.Charset;
import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.wisecoders.dbschema.dbf.JdbcDriver.LOGGER;
import static com.wisecoders.dbschema.dbf.io.H2Loader.FILES_META_TABLE;


/**
 * When you open a connection, we store transfer all DBF data to a local H2 database in user.home/.DbSchema/ .
 * We also create a proxy on Statement and intercept 'save dbf to folder_path' statements.
 * The dbf save code can be improved, we are happy for contributions.
 *
 * Copyright Wise Coders GmbH https://wisecoders.com
 * Driver is used in the DbSchema Database Designer https://dbschema.com
 * Free to be used by everyone.
 * Code modifications allowed only to GitHub repository https://github.com/wise-coders/dbf-jdbc-driver
 */

public class H2Connection implements Connection {

    private static final Pattern SAVE_COMMAND_PATTERN = Pattern.compile( "(\\s*)save(\\s+)dbf(\\s+)to(\\s+)(.*)", Pattern.CASE_INSENSITIVE );
    private static final Pattern RELOAD_PATTERN = Pattern.compile( "(\\s*)reload(\\s+)(.*)", Pattern.CASE_INSENSITIVE );

    private final JdbcConnection h2Connection;
    private final String defaultCharset;

    H2Connection(JdbcConnection h2Connection, String defaultCharset ){
        this.h2Connection = h2Connection;
        this.defaultCharset = defaultCharset;
    }

    @Override
    public Statement createStatement() throws SQLException {
        Statement statement = h2Connection.createStatement();
        return new StatementProxy(statement).proxyStatement;
    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
        Statement statement = h2Connection.createStatement(resultSetType, resultSetConcurrency );
        return new StatementProxy(statement).proxyStatement;
    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        Statement statement = h2Connection.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability );
        return new StatementProxy(statement).proxyStatement;
    }


    private class StatementProxy implements InvocationHandler {

        private final Object target;
        final Statement proxyStatement;

        StatementProxy(Object target) {
            this.target = target;
            this.proxyStatement = (Statement)Proxy.newProxyInstance(Statement.class.getClassLoader(),
                    new Class[]{Statement.class},
                    this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Matcher matcher;
            if (args != null && args.length > 0 ){
                if ( ( matcher = SAVE_COMMAND_PATTERN.matcher(args[0].toString())).matches()) {
                    LOGGER.info("Saving dbf...");
                    long start = System.currentTimeMillis();
                    try {
                        saveDbf(matcher.group(5));
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        throw ex;
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        throw new SQLException(ex.getLocalizedMessage(), ex);
                    }
                    args = new String[]{""};
                    long elapsed = System.currentTimeMillis() - start;
                    LOGGER.info("Executing " + method.getName() + " finished in " + elapsed + " ms");
                } else if ( ( matcher = RELOAD_PATTERN.matcher(args[0].toString())).matches()) {
                    LOGGER.info("Reload " + matcher.group(3) );
                    reload( matcher.group(3));
                    args = new String[]{""};
                }
            }
            return method.invoke(target, args);
        }
    }

    void transferFolder(File dbfFolder, File dbfSubFolder, Connection h2Connection, Charset defaultCharset ) throws SQLException {
        final File[] files = dbfSubFolder.listFiles();
        if ( files != null ) {
            for ( File dbfFile : files) {
                if ( dbfFile.isFile() ){
                    if ( dbfFile.getName().toLowerCase().endsWith(".dbf") ) {
                        try ( DBFReader reader = new DBFReader( new FileInputStream(dbfFile), defaultCharset )) {
                            final Table table = new Table( extractTableNameFrom( dbfFolder, dbfFile ));
                            if ( !H2Loader.isFileTransferred( dbfFile, h2Connection )){
                                H2Loader.transfer( table, reader, h2Connection );
                                H2Loader.saveFileIntoFilesMeta( table, dbfFile, h2Connection );
                            }
                        } catch (Exception ex) {
                            LOGGER.log(Level.SEVERE, "Error transferring " + dbfFile, ex);
                            throw new SQLException(ex.getLocalizedMessage(), ex);
                        }
                    }
                } else if ( dbfFile.isDirectory() ){
                    transferFolder( dbfFolder, dbfFile, h2Connection, defaultCharset );
                }
            }
        }
    }

    private static String extractTableNameFrom(File dbfFolder, File dbfFile) {
        String relativePath = dbfFolder.toURI().relativize(dbfFile.toURI()).getPath();
        if ( relativePath.toLowerCase().endsWith(".dbf")){
            relativePath = relativePath.substring(0, relativePath.length() - ".dbf".length());
        }
        return relativePath;
    }


    private void saveDbf( String path) throws Exception {
        if ( path == null || path.trim().length() == 0 ){
            throw new SQLException("Save dbf path is empty. Please specify a directory path");
        }
        path = path.trim();
        if ( ( path.startsWith("'") || path.endsWith("'") ) || ( path.startsWith("\"") || path.endsWith("\"") )){
            path = path.substring(1, path.length()-1);
        }
        File outputFolder = new File ( path );
        outputFolder.mkdirs();
        new H2Writer(h2Connection, outputFolder, defaultCharset );
    }

    private void reload( String filePath ) throws Exception {
        try (PreparedStatement st = h2Connection.prepareStatement("DELETE FROM " + FILES_META_TABLE + " WHERE file_path=?")) {
            st.setString(1, filePath);
            st.executeUpdate();
        }
    }


    @Override
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return h2Connection.prepareStatement( sql );
    }

    @Override
    public CallableStatement prepareCall(String sql) throws SQLException {
        return h2Connection.prepareCall( sql );
    }

    @Override
    public String nativeSQL(String sql) throws SQLException {
        return h2Connection.nativeSQL( sql );
    }

    @Override
    public void setAutoCommit(boolean autoCommit) throws SQLException {
        h2Connection.setAutoCommit( autoCommit );
    }

    @Override
    public boolean getAutoCommit() throws SQLException {
        return h2Connection.getAutoCommit();
    }

    @Override
    public void commit() throws SQLException {
        h2Connection.commit();
    }

    @Override
    public void rollback() throws SQLException {
        h2Connection.rollback();
    }

    @Override
    public void close() throws SQLException {
        h2Connection.close();
    }

    @Override
    public boolean isClosed() throws SQLException {
        return h2Connection.isClosed();
    }

    @Override
    public DatabaseMetaData getMetaData() throws SQLException {
        return h2Connection.getMetaData();
    }

    @Override
    public void setReadOnly(boolean readOnly) throws SQLException {
        h2Connection.setReadOnly( readOnly );
    }

    @Override
    public boolean isReadOnly() throws SQLException {
        return h2Connection.isReadOnly();
    }

    @Override
    public void setCatalog(String catalog) throws SQLException {
        h2Connection.setCatalog( catalog );
    }

    @Override
    public String getCatalog() throws SQLException {
        return h2Connection.getCatalog();
    }

    @Override
    public void setTransactionIsolation(int level) throws SQLException {
        h2Connection.setTransactionIsolation( level );
    }

    @Override
    public int getTransactionIsolation() throws SQLException {
        return h2Connection.getTransactionIsolation();
    }

    @Override
    public SQLWarning getWarnings() throws SQLException {
        return h2Connection.getWarnings();
    }

    @Override
    public void clearWarnings() throws SQLException {
        h2Connection.clearWarnings();
    }



    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        return h2Connection.prepareStatement( sql, resultSetType, resultSetConcurrency );
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        return h2Connection.prepareCall( sql, resultSetType, resultSetConcurrency );
    }

    @Override
    public Map<String, Class<?>> getTypeMap() throws SQLException {
        return h2Connection.getTypeMap();
    }

    @Override
    public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
        h2Connection.setTypeMap( map );
    }

    @Override
    public void setHoldability(int holdability) throws SQLException {
        h2Connection.setHoldability( holdability );
    }

    @Override
    public int getHoldability() throws SQLException {
        return h2Connection.getHoldability();
    }

    @Override
    public Savepoint setSavepoint() throws SQLException {
        return h2Connection.setSavepoint();
    }

    @Override
    public Savepoint setSavepoint(String name) throws SQLException {
        return h2Connection.setSavepoint(name);
    }

    @Override
    public void rollback(Savepoint savepoint) throws SQLException {
        h2Connection.rollback(savepoint );
    }

    @Override
    public void releaseSavepoint(Savepoint savepoint) throws SQLException {
        h2Connection.releaseSavepoint( savepoint );
    }



    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return h2Connection.prepareStatement( sql, resultSetType, resultSetConcurrency, resultSetHoldability );
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return h2Connection.prepareCall( sql, resultSetType, resultSetConcurrency, resultSetHoldability );
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
        return h2Connection.prepareStatement( sql, autoGeneratedKeys );
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
        return h2Connection.prepareStatement(sql, columnIndexes);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
        return h2Connection.prepareStatement( sql, columnNames);
    }

    @Override
    public Clob createClob() throws SQLException {
        return h2Connection.createClob();
    }

    @Override
    public Blob createBlob() throws SQLException {
        return h2Connection.createBlob();
    }

    @Override
    public NClob createNClob() throws SQLException {
        return h2Connection.createNClob();
    }

    @Override
    public SQLXML createSQLXML() throws SQLException {
        return h2Connection.createSQLXML();
    }

    @Override
    public boolean isValid(int timeout) throws SQLException {
        return h2Connection.isValid(timeout);
    }

    @Override
    public void setClientInfo(String name, String value) throws SQLClientInfoException {
        h2Connection.setClientInfo( name, value );
    }

    @Override
    public void setClientInfo(Properties properties) throws SQLClientInfoException {
        h2Connection.setClientInfo(properties);
    }

    @Override
    public String getClientInfo(String name) throws SQLException {
        return h2Connection.getClientInfo(name);
    }

    @Override
    public Properties getClientInfo() throws SQLException {
        return h2Connection.getClientInfo();
    }

    @Override
    public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
        return h2Connection.createArrayOf( typeName, elements);
    }

    @Override
    public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
        return h2Connection.createStruct( typeName, attributes );
    }

    @Override
    public void setSchema(String schema) throws SQLException {
        h2Connection.setSchema( schema);
    }

    @Override
    public String getSchema() throws SQLException {
        return h2Connection.getSchema();
    }

    @Override
    public void abort(Executor executor) throws SQLException {
        h2Connection.abort(executor);
    }

    @Override
    public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
        h2Connection.setNetworkTimeout( executor, milliseconds );
    }

    @Override
    public int getNetworkTimeout() throws SQLException {
        return h2Connection.getNetworkTimeout();
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return h2Connection.unwrap(iface);
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return h2Connection.isWrapperFor( iface );
    }
}
