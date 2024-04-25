package com.wisecoders.dbschema.dbf.io;

import com.linuxense.javadbf.DBFField;

/**
 * Licensed under <a href="https://creativecommons.org/licenses/by-nd/4.0/deed.en">CC BY-ND 4.0 DEED</a>, copyright <a href="https://wisecoders.com">Wise Coders GmbH</a>, used by <a href="https://dbschema.com">DbSchema Database Designer</a>.
 * Code modifications allowed only as pull requests to the <a href="https://github.com/wise-coders/dbf-jdbc-driver">public GIT repository</a>.
 */
public class DBFUtil {

    public static String getFieldDescription(DBFField field) {
        return  field.getName().toLowerCase() + " " +
                field.getType().name() + "(" +
                field.getLength() + "," +
                field.getDecimalCount() + ")";
    }
}
