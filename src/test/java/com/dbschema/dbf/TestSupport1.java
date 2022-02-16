package com.dbschema.dbf;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Copyright Wise Coders GmbH https://wisecoders.com
 * Driver is used in the DbSchema Database Designer https://dbschema.com
 * Free to be used by everyone.
 * Code modifications allowed only to GitHub repository https://github.com/wise-coders/dbf-jdbc-driver
 */
public class TestSupport1 {

    @Test
    public void test() throws Exception{
        new JdbcDriver();
        final String URL = "jdbc:dbschema:dbf:src/test/resources/support1";
        Connection con = DriverManager.getConnection( URL );
    }
}
