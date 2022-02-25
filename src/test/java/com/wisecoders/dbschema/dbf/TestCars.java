package com.wisecoders.dbschema.dbf;

import org.junit.Test;

import java.sql.*;

/**
 * Copyright Wise Coders GmbH https://wisecoders.com
 * Driver is used in the DbSchema Database Designer https://dbschema.com
 * Free to be used by everyone.
 * Code modifications allowed only to GitHub repository https://github.com/wise-coders/dbf-jdbc-driver
 */
public class TestCars {

    private static final String URL = "jdbc:dbschema:dbf:src/test/resources/dbase5/cars?version=dbase_5";

    @Test
    public void test() throws SQLException {
        new JdbcDriver();
        Connection con = DriverManager.getConnection( URL );
        Statement st = con.createStatement();
        //st.execute("reload cars");
        if( st.execute("select * from cars")){
            ResultSet rs = st.getResultSet();
            while( rs.next() ){
                for( int i = 0; i < rs.getMetaData().getColumnCount(); i++ ){
                    System.out.print( rs.getString(i + 1 ) + ",");
                }
                System.out.println();
            }
        }
        st.execute("save dbf to out/testExport");
    }

}
