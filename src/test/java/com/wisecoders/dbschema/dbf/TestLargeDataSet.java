package com.wisecoders.dbschema.dbf;

import org.junit.Test;

import java.sql.*;

public class TestLargeDataSet {
    private static final String URL = "jdbc:dbschema:dbf:src/test/resources/largeDataSet/?charset=Cp850";

    @Test
    public void test() throws SQLException {
        new JdbcDriver();
        {
            Connection con = DriverManager.getConnection(URL);
            Statement st = con.createStatement();
            //st.execute("reload cars");
            if (st.execute("select * from lpp_histo_tot682")) {
                ResultSet rs = st.getResultSet();
                while (rs.next()) {
                    for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                        //System.out.print(rs.getString(i + 1) + ",");
                    }
                    //System.out.println();
                }
            }
            st.execute("save dbf to out/testExport");
        }
    }
}
