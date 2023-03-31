package com.wisecoders.dbschema.dbf.schema;

import com.linuxense.javadbf.DBFDataType;
import com.linuxense.javadbf.DBFField;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright Wise Coders GmbH https://wisecoders.com
 * Driver is used in the DbSchema Database Designer https://dbschema.com
 * Free to be used by everyone.
 * Code modifications allowed only to GitHub repository https://github.com/wise-coders/dbf-jdbc-driver
 */
public class Table {


    public final String name;
    public final List<DBFField> fields = new ArrayList<>();


    public Table(String name ){
        this.name = name;
    }

    public DBFField createDBFField(String name, String type, int length, int decimal  ) {
        DBFField field = new DBFField();
        if ( name.length() > 10 ){
            name = name.substring(0, 10);
        }
        field.setName( name.toUpperCase() );

        switch (type.toLowerCase() ){
            case "double":
            case "decimal":
                field.setType( DBFDataType.NUMERIC );
                field.setLength( length);
                field.setDecimalCount( decimal);
                break;
            case "float": field.setType( DBFDataType.FLOATING_POINT ); break;
            case "int": field.setType( DBFDataType.AUTOINCREMENT ); break;
            case "bigint": field.setType( DBFDataType.NUMERIC ); break;
            case "boolean": field.setType( DBFDataType.LOGICAL ); break;
            case "date": field.setType( DBFDataType.DATE ); break;
            case "bit": field.setType( DBFDataType.NULL_FLAGS ); break;
            case "longvarchar":field.setType( DBFDataType.MEMO ); break;
            case "timestamp":
                if ( DBFDataType.TIMESTAMP.isWriteSupported() ) {
                    field.setType( DBFDataType.TIMESTAMP );
                } else {
                    field.setType( DBFDataType.CHARACTER);
                    field.setLength( 256 );
                }
                break;
            case "timestampwithtimezone": field.setType( DBFDataType.TIMESTAMP_DBASE7 ); break;
            case "character":
                field.setType( DBFDataType.CHARACTER );
                field.setLength( length );
                break;
            default :
                // I TRIED ALSO DBFDataType.VARCHAR AND THE LIBRARY DOES NOT SUPPORT WRITING IT. MEMO ALSO NOT.
                field.setType( DBFDataType.CHARACTER );
                field.setLength( Math.min(length, 254 ));
                break;
        }
        fields.add( field );
        return field;
    }

    public DBFField[] getDBFFields(){
        return fields.toArray( new DBFField[]{});
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(name).append("(\n");
        for ( DBFField field : fields ){
            sb.append(field.getName().toUpperCase()).append(" ").append(field.getType()).append(" (").append(field.getLength()).append(", ").append(field.getDecimalCount()).append(" ) ").append(field.isNullable() ? "" : "NOT NULL ").append("\n");
        }
        sb.append(")");
        return sb.toString();
    }

}



