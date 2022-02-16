package com.dbschema.dbf;


import org.h2.jdbc.JdbcConnection;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.*;

/**
 * When you open a connection, we store transfer all DBF data to a local H2 database in user.home/.DbSchema/ .
 * We also create a proxy on Statement and intercept 'save dbf to folder_path' statements.
 * The dbf save code can be improved, we are happy for contributions.
 *
 * Copyright Wise Coders GmbH https://wisecoders.com
 * Driver is used in the DbSchema Database Designer https://dbschema.com
 * Free to be used by everyone.
 * Code modifications allowed only to GitHub repository https://github.com/wise-coders/dbf-jdbc-driver
 */

public class JdbcDriver implements Driver {

    private static final String PREFIX = "jdbc:dbschema:dbf:";
    private static final String INTERNAL_H2_LOCATION = "~/.DbSchema/jdbc-dbf-cache/";

    public static final Logger LOGGER = Logger.getLogger( JdbcDriver.class.getName() );

    static {
        try {
            DriverManager.registerDriver( new JdbcDriver());
            LOGGER.setLevel(Level.ALL);
            LOGGER.addHandler(
                    new ConsoleHandler() {
                        {setOutputStream(System.out);}
                    });
            final FileHandler fileHandler = new FileHandler(System.getProperty("user.home") + "/.DbSchema/logs/DbfJdbcDriver.log");
            fileHandler.setFormatter( new SimpleFormatter());
            LOGGER.addHandler(fileHandler);
        } catch ( Exception ex ){
            ex.printStackTrace();
        }
    }

    @Override
    public Connection connect( String url, Properties info ) throws SQLException {
        if ( acceptsURL(PREFIX)) {
            String defaultCharset = null;
            String path = url.substring(PREFIX.length());
            int idxQuestionMark = path.indexOf('?');
            if ( idxQuestionMark > 0 ){
                String params = path.substring( idxQuestionMark+1);
                path = path.substring(0, idxQuestionMark );
                for ( String paramSet: params.split("&")){
                    String[] pair = paramSet.split("=");
                    if ( pair.length == 2 ){
                        if ( "log".equalsIgnoreCase( pair[0]) || "logs".equalsIgnoreCase( pair[0])){
                            LOGGER.setLevel(Level.INFO);
                            ConsoleHandler handler = new ConsoleHandler();
                            handler.setFormatter( new SimpleFormatter());
                            LOGGER.addHandler(handler);
                        } else if ( "charset".equalsIgnoreCase( pair[0]) ) {
                            defaultCharset = pair[1];
                        }
                    }
                }
            }
            return getConnection( path, defaultCharset );
        } else {
            throw new SQLException("Incorrect URL. Expected jdbc:dbschema:dbf:<folderPath>");
        }
    }

    private final List<String> h2Databases = new ArrayList<>();


    private Connection getConnection( String databasePath, String defaultCharset ) throws SQLException {
        final File folder = new File(databasePath);
        if (!folder.exists()) {
            throw new SQLException("Folder does not exists: '" + folder + "'");
        }
        if (!folder.isDirectory()) {
            throw new SQLException("Expected path is not folder: '" + folder + "'");
        }
        final String h2DbName = md5Java( databasePath );
        final String h2DatabasePath = getInternalH2DatabasePath( h2DbName );
        final String h2JdbcUrl = "jdbc:h2:file:" + h2DatabasePath + ";database_to_upper=false";
        LOGGER.log(Level.INFO, "Create H2 database '" + h2JdbcUrl + "'");

        final JdbcConnection h2Connection = (JdbcConnection) (new org.h2.Driver().connect( h2JdbcUrl, new Properties() ));
        final H2WrappedConnection wrappedConnection = new H2WrappedConnection( h2Connection, defaultCharset);
        if ( !h2Databases.contains( h2DbName )){
            wrappedConnection.transferFolder(folder, folder, h2Connection);
            h2Databases.add(h2DbName);
        }
        return wrappedConnection;
    }


    private String getInternalH2DatabasePath(String path ){
        final File h2File = new File(INTERNAL_H2_LOCATION);
        if ( !h2File.exists()) {
            h2File.mkdirs();
        }
        return INTERNAL_H2_LOCATION + path;
    }

    @Override
    public boolean acceptsURL(String url) {
        return url.startsWith(PREFIX);
    }




    static class ExtendedDriverPropertyInfo extends DriverPropertyInfo {
        ExtendedDriverPropertyInfo( String name, String value, String[] choices, String description ){
            super( name, value);
            this.description = description;
            this.choices = choices;
        }
    }

    @Override
    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
        DriverPropertyInfo[] result = new DriverPropertyInfo[1];
        result[0] = new ExtendedDriverPropertyInfo("log", "true", new String[]{"true", "false"}, "Activate driver INFO logging");
        return result;
    }

    @Override
    public int getMajorVersion()
    {
        return 1;
    }


    @Override
    public int getMinorVersion()
    {
        return 0;
    }

    @Override
    public boolean jdbcCompliant() {
        return true;
    }

    @Override
    public Logger getParentLogger() {
        return null;
    }

    private static String md5Java(String message){
        String digest = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(message.getBytes("UTF-8"));

            //converting byte array to Hexadecimal String
            StringBuilder sb = new StringBuilder(2*hash.length);
            for(byte b : hash){
                sb.append(String.format("%02x", b&0xff));
            }

            digest = sb.toString();

        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            Logger.getLogger(JdbcDriver.class.getName()).log(Level.SEVERE, null, ex);
        }
        return digest;
    }





}
