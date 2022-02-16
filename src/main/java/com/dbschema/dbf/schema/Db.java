package com.dbschema.dbf.schema;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright Wise Coders GmbH https://wisecoders.com
 * Driver is used in the DbSchema Database Designer https://dbschema.com
 * Free to be used by everyone.
 * Code modifications allowed only to GitHub repository https://github.com/wise-coders/dbf-jdbc-driver
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
