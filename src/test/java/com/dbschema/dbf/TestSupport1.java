package com.dbschema.dbf;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestSupport1 {

    @Test
    public void test() throws Exception{
        new JdbcDriver();
        final String URL = "jdbc:dbschema:dbf:src/test/resources/support1";
        Connection con = DriverManager.getConnection( URL );
    }
}
