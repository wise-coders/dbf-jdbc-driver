package com.dbschema.xbase;

import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;


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
