package com.dbschema.xbase.schema;

import com.dbschema.xbase.io.DBFtoH2;
import com.linuxense.javadbf.DBFField;

import java.sql.Types;

/**
 * Copyright Wise Coders GmbH. All rights reserved. Free to use, contributions accepted only in https://bitbucket.org/dbschema/dbf-jdbc-driver
 */
public class DataTypeUtil {


    public static int getJavaType( DBFField field ) {
        switch (field.getType()) {
            case UNKNOWN:
                return Types.OTHER;
            case VARBINARY:
            case BLOB:
            case GENERAL_OLE:
                return Types.BLOB;
            case NUMERIC:
                return Types.DECIMAL;
            case LONG:
                return Types.DECIMAL;
            case AUTOINCREMENT:
                return Types.INTEGER;
            case CURRENCY:
                return Types.OTHER;
            case TIMESTAMP:
                return Types.TIMESTAMP;
            case TIMESTAMP_DBASE7:
                return Types.TIMESTAMP_WITH_TIMEZONE;
            case NULL_FLAGS:
                return Types.NULL;
            case DOUBLE:
                return Types.DECIMAL;
            case FLOATING_POINT:
                return Types.FLOAT;
            case CHARACTER:
                return Types.CHAR;
            case LOGICAL:
                return Types.BOOLEAN;
            case DATE:
                return Types.DATE;
            case MEMO:
                return Types.LONGNVARCHAR;
            case PICTURE:
            case BINARY:
                return Types.BINARY;
            case VARCHAR:
                return Types.VARCHAR;
            default:
                return Types.VARCHAR;
        }
    }

    public static String getH2Type( DBFField field ) {
        switch ( field.getType() ) {
            case BINARY:
            case DOUBLE:
                return "double";
            case FLOATING_POINT:
                return "float";
            case CHARACTER:
                return "char(" + field.getLength() + ")";
            case LOGICAL:
                return "boolean";
            case DATE:
                return "date";
            case MEMO:
                return "longvarchar(" + Integer.MAX_VALUE + ")";
            case VARCHAR:
                return "varchar(" + field.getLength() + ")";
            case PICTURE:
            case UNKNOWN:
            case BLOB:
            case GENERAL_OLE:
                return "binary";
            case VARBINARY:
            case NUMERIC:
                return "decimal(" + ( field.getLength() + field.getDecimalCount() ) + "," + field.getDecimalCount() + ")";
            case LONG:
                return "bigint";
            case CURRENCY:
            case AUTOINCREMENT:
                return "bigint";
            case TIMESTAMP:
                return "timestamp";
            case TIMESTAMP_DBASE7:
                return "timestampwithtimezone";
            case NULL_FLAGS:
                return "bit";
            default:
                return "varchar(" + Integer.MAX_VALUE + ")";
        }
    }

    private static final String[] H2_SYSTEM_TABLES = new String[]{"CATALOGS", "COLLATIONS", "COLUMNS", "COLUMN_PRIVILEGES", "CONSTANTS", "CONSTRAINTS", "CROSS_REFERENCES", "DOMAINS",
            "FUNCTION_ALIASES", "FUNCTION_COLUMNS", "HELP", "INDEXES", "IN_DOUBT", "KEY_COLUMN_USAGE", "LOCKS", "QUERY_STATISTICS", "REFERENTIAL_CONSTRAINTS", "RIGHTS", "ROLES",
            "SCHEMATA", "SEQUENCES", "SYNONYMS", "SESSIONS", "SESSION_STATE", "SETTINGS", "TABLES", "TABLE_CONSTRAINTS", "TABLE_PRIVILEGES", "TABLE_TYPES", "TRIGGERS", "TYPE_INFO", "USERS", "VIEWS"};


    public static boolean isH2SystemTable( String tableName ){
        for ( String systemName : H2_SYSTEM_TABLES ){
            if( systemName.equalsIgnoreCase( tableName )) return true;
        }
        return DBFtoH2.META_TABLE_NAME.equalsIgnoreCase( tableName );
    }

}