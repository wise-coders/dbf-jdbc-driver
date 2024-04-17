package com.wisecoders.dbschema.dbf.schema;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright Wise Coders GmbH <a href="https://wisecoders.com">...</a>
 * Driver is used in the DbSchema Database Designer <a href="https://dbschema.com">DbSchema</a>
 * Free to be used by everyone.
 * Code modifications allowed only to GitHub repository <a href="https://github.com/wise-coders/dbf-jdbc-driver">DBF JDBC Driver GitHub</a>
 */

public class Db {

    private final Map<String, Table> tables = new HashMap<>();

    public Table getOrCreateTable(String tableName ){
        if ( tables.containsKey( tableName )){
            return tables.get(tableName);
        } else {
            Table table = new Table(tableName);
            tables.put( tableName, table);
            return table;
        }
    }

    public Collection<Table> getTables(){
        return tables.values();
    }

}
