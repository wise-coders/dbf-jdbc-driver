package com.dbschema.xbase.io;

import com.dbschema.xbase.schema.DataTypeUtil;
import com.dbschema.xbase.schema.Table;
import com.linuxense.javadbf.DBFField;
import com.linuxense.javadbf.DBFReader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

import static com.dbschema.xbase.DbfJdbcDriver.LOGGER;

/**
 * Copyright DbSchema@Wise Coders GmbH. All rights reserved.
 *  Licensed under BSD License-3: free to use, distribution forbidden. Improvements accepted only in https://bitbucket.org/dbschema/dbf-jdbc-driver
 */
public class DBFtoH2 {

    private String insertSql;
    private String charset;

    private final static char QUOTE_CHAR = '"';
    public static final String META_TABLE_NAME = "dbs_meta_columns";
    private static final String INSERT_INTO_META_TABLE =
            "insert into " + META_TABLE_NAME + "( table_name, column_name, column_type, length, decimal ) values ( ?,?,?,?,? )";


    public void transfer( Table table, DBFReader dbfReader, Connection h2Connection ) throws Exception {
        this.charset = ( dbfReader.getCharset() != null ) ? dbfReader.getCharset().name() : null;
        dropH2MetaTable( h2Connection );
        createH2MetaTable( h2Connection );
        transferDefinition( table, dbfReader, h2Connection );
        transferData( table, dbfReader, h2Connection );
    }

    private void transferDefinition(Table table, DBFReader reader, Connection h2Connection ) throws Exception {
        LOGGER.log(Level.INFO, "Transfer table '" + table.name + "' definition.");
        final StringBuilder createSb = new StringBuilder("create table ").append(QUOTE_CHAR).append(table.name).append(QUOTE_CHAR).append("(\n");
        final StringBuilder insertSb = new StringBuilder("insert into ").append(QUOTE_CHAR).append(table.name).append(QUOTE_CHAR).append("(");
        final StringBuilder insertValuesSb = new StringBuilder("values(");
        boolean appendComma = false;
        int numberOfFields = reader.getFieldCount();
        for (int i = 0; i < numberOfFields; i++) {

            final DBFField field = reader.getField(i);
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

        String dropTableSQL = "drop table if exists " + QUOTE_CHAR + table.name + QUOTE_CHAR;
        LOGGER.log(Level.INFO, dropTableSQL);
        h2Connection.prepareStatement(dropTableSQL).execute();
        h2Connection.commit();


        LOGGER.log(Level.INFO, createSb.toString());
        h2Connection.prepareStatement(createSb.toString()).execute();
        h2Connection.commit();

        this.insertSql = insertSb.toString() + insertValuesSb.toString();
    }


    private void transferData(Table table, DBFReader reader, Connection h2Connection  ) throws Exception {
        final PreparedStatement stInsert = h2Connection.prepareStatement(insertSql);
        LOGGER.info("Transfer '" + table.name + "' data...");
        Object[] record;
        int pos = 0, pendingInsert = 0, pendingCommit = 0;
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
            pendingInsert++;
            pendingCommit++;
            if ( pendingInsert > 300 ){
                stInsert.executeBatch();
                pendingInsert = 0;
                if ( pendingCommit > 10000 ){
                    h2Connection.commit();
                    pendingCommit = 0;
                    LOGGER.info("Transfer '" + table.name + "' data " + pos + " records.");
                }
            }
        }
        if ( pendingInsert > 0 ) {
            stInsert.executeBatch();
        }
        h2Connection.commit();
    }

    private static final String CREATE_META_TABLE =
            "create table if not exists " + META_TABLE_NAME + "( " +
                    "table_name varchar(2000) not null, " +
                    "column_name varchar(2000) not null, " +
                    "column_type varchar(120), " +
                    "length int not null, " +
                    "decimal int not null, " +
                    "primary key (table_name, column_name))";

    private void createH2MetaTable( Connection h2Connection ) throws SQLException {
        final Statement st = h2Connection.createStatement();
        st.execute( CREATE_META_TABLE );
        st.close();
        h2Connection.commit();
    }

    private static final String DROP_META_TABLE =
            "drop table if exists " + META_TABLE_NAME;

    private void dropH2MetaTable( Connection h2Connection ) throws SQLException {
        final Statement st = h2Connection.createStatement();
        st.execute( DROP_META_TABLE );
        st.close();
        h2Connection.commit();
    }

    private void saveFieldInMetaTable( Connection h2Connection, Table table, DBFField field) throws SQLException {
        final PreparedStatement st = h2Connection.prepareStatement( INSERT_INTO_META_TABLE);
        st.setString( 1, table.name);
        st.setString( 2, field.getName() );
        st.setString( 3, field.getType().name() );
        st.setInt( 4, field.getLength() );
        st.setInt( 5, field.getDecimalCount() );
        st.execute();
        h2Connection.commit();
    }

    public String getCharset(){
        return charset;
    }


}
