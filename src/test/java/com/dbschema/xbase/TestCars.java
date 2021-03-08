package com.dbschema.xbase;

import org.junit.Test;

import java.sql.*;

public class TestCars {

    private static final String URL = "jdbc:dbschema:dbf:src/test/resources/dbase5/cars?version=dbase_5";

    @Test
    public void test() throws SQLException {
        new DbfJdbcDriver();
        Connection con = DriverManager.getConnection( URL );
        Statement st = con.createStatement();
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
