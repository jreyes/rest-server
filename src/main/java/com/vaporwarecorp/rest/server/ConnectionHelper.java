package com.vaporwarecorp.rest.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper
{
// ------------------------------ FIELDS ------------------------------

    private static ConnectionHelper instance;

    private String url;

// -------------------------- STATIC METHODS --------------------------

    public static void close( Connection connection )
    {
        try
        {
            if ( connection != null )
            {
                connection.close();
            }
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
    }

    public static Connection getConnection()
        throws SQLException
    {
        if ( instance == null )
        {
            instance = new ConnectionHelper();
        }
        return DriverManager.getConnection( instance.url );
    }

// --------------------------- CONSTRUCTORS ---------------------------

    private ConnectionHelper()
    {
        try
        {
            Class.forName( "org.hsqldb.jdbc.JDBCDriver" );
            url = "jdbc:hsqldb:res:/testdb;user=SA";
        }
        catch ( Exception e )
        {
            System.err.println( "ERROR: failed to load HSQLDB JDBC driver." );
            e.printStackTrace();
        }
    }
}
