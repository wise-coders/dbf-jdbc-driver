package com.wisecoders.dbschema.dbf.io;

import com.wisecoders.dbschema.dbf.schema.DataTypeUtil;
import com.wisecoders.dbschema.dbf.schema.Table;
import com.linuxense.javadbf.DBFField;
import com.linuxense.javadbf.DBFReader;

import java.io.File;
import java.sql.*;
import java.util.logging.Level;

import static com.wisecoders.dbschema.dbf.JdbcDriver.LOGGER;

/**
 * Copyright Wise Coders GmbH https://wisecoders.com
 * Driver is used in the DbSchema Database Designer https://dbschema.com
 * Free to be used by everyone.
 * Code modifications allowed only to GitHub repository https://github.com/wise-coders/dbf-jdbc-driver
 */
public class DBFtoH2 {


    private final static char QUOTE_CHAR = '"';
    public static final String COLUMNS_META_TABLE = "dbs_meta_columns";
    private static final String INSERT_INTO_COLUMNS_META_TABLE = "insert into " + COLUMNS_META_TABLE + "( table_name, column_name, column_type, length, decimal ) values ( ?,?,?,?,? )";

    public static final String FILES_META_TABLE = "dbs_meta_files";
    private static final String CREATE_META_FILES = "CREATE TABLE IF NOT EXISTS " + FILES_META_TABLE + " ( file_path varchar(250) NOT NULL PRIMARY KEY, size bigint NOT NULL, last_modified bigint NOT NULL ) ";



    public static boolean isFileTransferred(File file, Connection h2Connection ) throws SQLException {
        h2Connection.prepareStatement(CREATE_META_FILES).execute();
        h2Connection.commit();

        String filePath = file.getAbsolutePath();
        long fileLastModified = file.lastModified();
        long fileSize = file.length();
        try (PreparedStatement st = h2Connection.prepareStatement("SELECT size, last_modified FROM " + FILES_META_TABLE + " WHERE file_path=?")) {
            st.setString(1, filePath);
            ResultSet rs = st.executeQuery();
            if (rs.next() && rs.getLong(1) == fileSize && rs.getLong(2) == fileLastModified) {
                LOGGER.info("File " + file.getAbsolutePath() + " is already loaded in H2.");
                return true;
            }
            rs.close();
        }
        return false;
    }

    public static void saveFileTransferredInfo( File file, Connection h2Connection ) throws SQLException {
        String filePath = file.getAbsolutePath();
        long fileLastModified = file.lastModified();
        long fileSize = file.length();
        try ( PreparedStatement st = h2Connection.prepareStatement("MERGE INTO " + FILES_META_TABLE + " ( file_path, size, last_modified ) KEY(file_path) VALUES ( ?, ?, ? )") ) {
            st.setString(1, filePath);
            st.setLong(2, fileSize);
            st.setLong(3, fileLastModified);
            st.executeUpdate();
        }
    }

    public static void transfer(Table table, DBFReader reader, Connection h2Connection ) throws Exception {
        createH2MetaTable( h2Connection );
        deleteFromH2MetaTable( h2Connection, table );

        //
        // TRANSFER DEFINITION
        //
        LOGGER.log(Level.INFO, "Transfer table '" + table.name + "' definition.");
        final StringBuilder createSb = new StringBuilder("create table ").append(QUOTE_CHAR).append(table.name).append(QUOTE_CHAR).append("(\n");
        final StringBuilder insertSb = new StringBuilder("insert into ").append(QUOTE_CHAR).append(table.name).append(QUOTE_CHAR).append("(");
        final StringBuilder insertValuesSb = new StringBuilder("values(");
        final StringBuilder dbfInfo = new StringBuilder();
        dbfInfo.append("Table ").append( table.name ).append( "\n" );
        boolean appendComma = false;
        int numberOfFields = reader.getFieldCount();
        for (int i = 0; i < numberOfFields; i++) {

            final DBFField field = reader.getField(i);
            dbfInfo.append( "\t").append( getFieldDescription( field )).append(" \n");
            saveFieldInMetaTable(h2Connection, table, field);
            table.addField(field);
            if (appendComma) {
                createSb.append(",\n");
                insertSb.append(",");
                insertValuesSb.append(",");
            }
            createSb.append("\t").append(QUOTE_CHAR).append(field.getName()).append(QUOTE_CHAR).append(" ");
            insertSb.append(QUOTE_CHAR).append(field.getName()).append(QUOTE_CHAR);
            insertValuesSb.append("?");
            createSb.append( DataTypeUtil.getH2Type( field));
            appendComma = true;
        }
        createSb.append(")");
        insertSb.append(")");
        insertValuesSb.append(")");

        LOGGER.log(Level.INFO, "Transfer "  + dbfInfo );

        String dropTableSQL = "drop table if exists " + QUOTE_CHAR + table.name + QUOTE_CHAR;
        LOGGER.log(Level.INFO, dropTableSQL);
        h2Connection.prepareStatement(dropTableSQL).execute();
        h2Connection.commit();


        LOGGER.log(Level.INFO, createSb.toString());
        h2Connection.prepareStatement(createSb.toString()).execute();
        h2Connection.commit();

        int batchSize, commitSize;

        String insertSql = insertSb.toString() + insertValuesSb.toString();
        batchSize = getChunk( 400, numberOfFields );
        commitSize = getChunk( 4000, numberOfFields );

        //
        // TRANSFER DATA
        //

        final PreparedStatement stInsert = h2Connection.prepareStatement(insertSql);
        LOGGER.info("Transfer '" + table.name + "' data...");
        Object[] record;
        int pos = 0, pendingBatch = 0, pendingCommit = 0;
        while( ( record = reader.nextRecord()) != null ){

            try {
                for (int i = 0; i < record.length && i < table.fields.size(); i++) {
                    Object value = record[i];
                    DBFField field = table.fields.get(i);
                    if (value == null) {
                        stInsert.setNull(i + 1, DataTypeUtil.getJavaType(field));
                    } else {
                        stInsert.setObject(i + 1, value);
                    }
                }
            } catch ( Exception ex ){
                LOGGER.log(Level.SEVERE, ex.toString());
                LOGGER.log(Level.SEVERE, stInsert.toString());
                throw ex;
            }
            stInsert.addBatch();
            h2Connection.commit();
            pos++;
            pendingBatch++;
            pendingCommit++;
            if ( pendingBatch > batchSize ){
                stInsert.executeBatch();
                pendingBatch = 0;
                if ( pendingCommit > commitSize ){
                    h2Connection.commit();
                    pendingCommit = 0;
                    LOGGER.info("Transfer '" + table.name + "' data " + pos + " records.");
                }
            }
        }
        if ( pendingBatch > 0 ) {
            stInsert.executeBatch();
        }
        h2Connection.commit();
    }

    private static int getChunk( int maxChunkSize, int numberOfFields ){
        return maxChunkSize - 9 * Math.min( numberOfFields, maxChunkSize/10 );
    }



    private static final String CREATE_COLUMNS_META_TABLE =
            "create table if not exists " + COLUMNS_META_TABLE + "( " +
                    "table_name varchar(2000) not null, " +
                    "column_name varchar(2000) not null, " +
                    "column_type varchar(120), " +
                    "length int not null, " +
                    "decimal int not null, " +
                    "primary key (table_name, column_name))";


    private static void createH2MetaTable( Connection h2Connection ) throws SQLException {
        final Statement st = h2Connection.createStatement();
        LOGGER.log(Level.INFO, CREATE_COLUMNS_META_TABLE);
        st.execute(CREATE_COLUMNS_META_TABLE);
        st.close();
        h2Connection.commit();
    }

    private static final String DELETE_FROM_META_TABLE = "delete from " + COLUMNS_META_TABLE  + " WHERE table_name=?";

    private static void deleteFromH2MetaTable(Connection h2Connection, Table table ) throws SQLException {
        LOGGER.log( Level.INFO,"Execute: " + DELETE_FROM_META_TABLE);
        final PreparedStatement st = h2Connection.prepareStatement( DELETE_FROM_META_TABLE );
        st.setString( 1, table.name );
        st.executeUpdate();
        st.close();
        h2Connection.commit();
    }

    private static String getFieldDescription(DBFField field) {
        return  field.getName() + " " +
                field.getType().name() + "(" +
                field.getLength() + "," +
                field.getDecimalCount() + ")";
    }

    private static void saveFieldInMetaTable( Connection h2Connection, Table table, DBFField field) throws SQLException {
        final PreparedStatement st = h2Connection.prepareStatement( INSERT_INTO_COLUMNS_META_TABLE );
        st.setString( 1, table.name);
        st.setString( 2, field.getName() );
        st.setString( 3, field.getType().name() );
        st.setInt( 4, field.getLength() );
        st.setInt( 5, field.getDecimalCount() );
        st.execute();
        h2Connection.commit();
    }


}
