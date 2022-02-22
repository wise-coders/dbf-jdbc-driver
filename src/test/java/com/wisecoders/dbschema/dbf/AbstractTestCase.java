package com.wisecoders.dbschema.dbf;

import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

/**
 * Copyright Wise Coders GmbH https://wisecoders.com
 * Driver is used in the DbSchema Database Designer https://dbschema.com
 * Free to be used by everyone.
 * Code modifications allowed only to GitHub repository https://github.com/wise-coders/dbf-jdbc-driver
 */
public abstract class AbstractTestCase {
    protected String dataDirectory;

    @Parameters
    public static Collection<Object[]> data()
    {
        final Object[][] testParameters =
                new Object[][]
                        {
                                { "dbase3plus" },
                                { "dbase4" },
                                { "dbase5" },
                                { "clipper5" },
                                { "foxpro26" }
                        };

        return Arrays.asList(testParameters);
    }


    protected AbstractTestCase(final String dataDirectory)
    {
        this.dataDirectory = dataDirectory;
    }
}
