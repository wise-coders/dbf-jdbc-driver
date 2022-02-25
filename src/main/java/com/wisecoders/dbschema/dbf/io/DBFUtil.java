package com.wisecoders.dbschema.dbf.io;

import com.linuxense.javadbf.DBFField;

public class DBFUtil {

    public static String getFieldDescription(DBFField field) {
        return  field.getName().toLowerCase() + " " +
                field.getType().name() + "(" +
                field.getLength() + "," +
                field.getDecimalCount() + ")";
    }
}
