package com.dbschema.xbase.io;


import com.dbschema.xbase.schema.Db;
import com.dbschema.xbase.schema.DataTypeUtil;
import com.dbschema.xbase.schema.Table;
import com.linuxense.javadbf.DBFWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.dbschema.xbase.DbfJdbcDriver.LOGGER;

/**
 * Copyright DbSchema@Wise Coders GmbH. All rights reserved.
 *  Licensed under BSD License-3: free to use, distribution forbidden. Improvements accepted only in https://bitbucket.org/dbschema/dbf-jdbc-driver
 */
public class H2toDBF {


    public H2toDBF(Connection h2Connection, File outputFolder, String charset ) throws Exception {

        Db db = new Db();

        final ResultSet rsColumns = h2Connection.getMetaData().getColumns( null, null, null, null );
        while( rsColumns.next() ){
            String tableName = rsColumns.getString( 3 );
            if ( !DataTypeUtil.isH2SystemTable(tableName )) {
                String columnName = rsColumns.getString(4);
                LOGGER.info("Define column " + tableName + "." + columnName);
                db.getOrCreateTable( tableName).createField(columnName, rsColumns.getString(6), rsColumns.getInt(7), rsColumns.getInt(9));
            }
        }

        for ( Table table : db.getTables() ){
            final File outputFile = new File( outputFolder.toURI().resolve( table.name + ".dbf"));
            LOGGER.info("Storing " + table + "...");

            final FileOutputStream os = new FileOutputStream(outputFile);
            final DBFWriter writer = charset != null ? new DBFWriter(os, Charset.forName(charset)) : new DBFWriter(os);
            writer.setFields( table.getDBFFields() );

            try ( Statement st = h2Connection.createStatement()) {
                ResultSet rs = st.executeQuery("SELECT * FROM " + table.name);
                int recCount = 0;
                while (rs.next()) {
                    int columnCount = rs.getMetaData().getColumnCount();
                    Object[] data = new Object[columnCount];
                    for (int i = 0; i < columnCount; i++) {
                        data[i] = rs.getObject(i + 1);
                    }
                    try {
                        writer.addRecord(data);
                    } catch ( Throwable ex ){
                        StringBuilder sb = new StringBuilder();
                        sb.append("Error saving ").append( outputFile.getAbsolutePath() ).append( " record : [");
                        for ( Object obj: data){
                            if ( obj == null ){
                                sb.append("null");
                            } else {
                                sb.append("'").append( obj.toString()).append("'");
                            }
                            sb.append(",");
                        }
                        sb.append(" ]");
                        throw new SQLException(sb.toString() + ex.getLocalizedMessage(), ex );
                    }
                    recCount++;
                }
                rs.close();
                writer.close();
                LOGGER.info("Stored " + table.name + " " + recCount + " records." );
            }
        }
    }




}
