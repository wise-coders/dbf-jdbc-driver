package com.wisecoders.dbschema.dbf.io;

import com.wisecoders.dbschema.dbf.schema.DataTypeUtil;
import com.wisecoders.dbschema.dbf.schema.Table;
import com.linuxense.javadbf.DBFField;
import com.linuxense.javadbf.DBFReader;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import static com.wisecoders.dbschema.dbf.JdbcDriver.LOGGER;

/**
 * Copyright Wise Coders GmbH https://wisecoders.com
 * Driver is used in the DbSchema Database Designer https://dbschema.com
 * Free to be used by everyone.
 * Code modifications allowed only to GitHub repository https://github.com/wise-coders/dbf-jdbc-driver
 */
public class H2Loader {


    private final static char QUOTE_CHAR = '"';
    public static final String COLUMNS_META_TABLE = "dbs_meta_columns";
    private static final String INSERT_INTO_COLUMNS_META_TABLE = "insert into " + COLUMNS_META_TABLE + "( table_name, column_name, column_type, length, decimal ) values ( ?,?,?,?,? )";

    public static final String FILES_META_TABLE = "dbs_meta_files";
    private static final String CREATE_META_FILES = "CREATE TABLE IF NOT EXISTS " + FILES_META_TABLE + " ( file_path varchar(250) NOT NULL PRIMARY KEY, table_name varchar(2000) NOT NULL, size bigint NOT NULL, last_modified bigint NOT NULL ) ";



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

    public static void saveFileIntoFilesMeta(Table table, File file, Connection h2Connection ) throws SQLException {
        try ( PreparedStatement st = h2Connection.prepareStatement("MERGE INTO " + FILES_META_TABLE + " ( file_path, table_name, size, last_modified ) KEY(file_path) VALUES ( ?, ?, ?, ? )") ) {
            String fileName = file.getName();

            st.setString(1, file.getAbsolutePath());
            st.setString(2, table.name );
            st.setLong(3, file.length());
            st.setLong(4, file.lastModified());
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
        final StringBuilder logSb = new StringBuilder();
        logSb.append("Table ").append( table.name ).append( "\n" );
        boolean appendComma = false;
        int numberOfFields = reader.getFieldCount();
        final List<DBFField> dbfFieldList = new ArrayList<>();
        for (int i = 0; i < numberOfFields; i++) {

            final DBFField field = reader.getField(i);
            logSb.append( "\t").append( DBFUtil.getFieldDescription( field )).append(" \n");
            saveFieldInMetaTable(h2Connection, table, field);
            dbfFieldList.add(field);
            if (appendComma) {
                createSb.append(",\n");
                insertSb.append(",");
                insertValuesSb.append(",");
            }
            createSb.append("\t").append(QUOTE_CHAR).append(field.getName().toLowerCase()).append(QUOTE_CHAR).append(" ");
            insertSb.append(QUOTE_CHAR).append(field.getName().toLowerCase()).append(QUOTE_CHAR);
            insertValuesSb.append("?");
            createSb.append( DataTypeUtil.getH2Type( field));
            appendComma = true;
        }
        createSb.append(")");
        insertSb.append(")");
        insertValuesSb.append(")");

        LOGGER.log(Level.INFO, "Transfer "  + logSb );

        String dropTableSQL = "drop table if exists " + QUOTE_CHAR + table.name + QUOTE_CHAR;
        LOGGER.log(Level.INFO, dropTableSQL);
        h2Connection.prepareStatement(dropTableSQL).execute();
        h2Connection.commit();


        LOGGER.log(Level.INFO, createSb.toString());
        h2Connection.prepareStatement(createSb.toString()).execute();
        h2Connection.commit();

        String insertSql = insertSb.toString() + insertValuesSb.toString();
        final int batchSize = Math.max( 50, 500 - (numberOfFields*3) );

        //
        // TRANSFER DATA
        //

        final PreparedStatement stInsert = h2Connection.prepareStatement(insertSql);
        LOGGER.info("Transfer '" + table.name + "' data...");
        Object[] record;
        int pos = 0, pendingBatch = 0;
        long _start = System.currentTimeMillis();
        while( ( record = reader.nextRecord()) != null ){
            try {
                for (int i = 0; i < record.length && i < dbfFieldList.size(); i++) {
                    Object value = record[i];
                    DBFField field = dbfFieldList.get(i);
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
            pos++;
            pendingBatch++;
            if ( pendingBatch > batchSize ){
                stInsert.executeBatch();
                h2Connection.commit();
                pendingBatch = 0;
            }
        }
        if ( pendingBatch > 0 ) {
            stInsert.executeBatch();
        }
        h2Connection.commit();
        LOGGER.info("------- Transferred '" + table.name + "' " + pos + " records in " + (System.currentTimeMillis() - _start) + " ms" );
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



    private static void saveFieldInMetaTable( Connection h2Connection, Table table, DBFField field) throws SQLException {
        final PreparedStatement st = h2Connection.prepareStatement( INSERT_INTO_COLUMNS_META_TABLE );
        st.setString( 1, table.name);
        st.setString( 2, field.getName().toLowerCase() );
        st.setString( 3, field.getType().name() );
        st.setInt( 4, field.getLength() );
        st.setInt( 5, field.getDecimalCount() );
        st.execute();
        h2Connection.commit();
    }


}
