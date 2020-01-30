/*
 * Copyright 2009-2010 Data Archiving and Networked Services (DANS), Netherlands.
 *
 * This file is part of DANS DBF Library.
 *
 * DANS DBF Library is free software: you can redistribute it and/or modify it under the terms of
 * the GNU General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 *
 * DANS DBF Library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with DANS DBF Library. If
 * not, see <http://www.gnu.org/licenses/>.
 */
package com.dbschema.xbase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.sql.DriverManager;
import java.sql.SQLException;


@RunWith(Parameterized.class)
public class TestAllDataFolders extends AbstractTestCase {

    public TestAllDataFolders(final String aVersionDirectory)
    {
        super( aVersionDirectory);
    }

    @Test
    public void testDriver() throws SQLException {
        new DbfJdbcDriver();
        final String URL = "jdbc:dbschema:dbf:src/test/resources/" + dataDirectory + "/cars";
        DriverManager.getConnection( URL );
    }
}
