package com.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class JDBCHelper {
    private static Connection connection;
    static
    {
        try
        {
            System.out.println(new JDBCConstants());
            Class.forName( JDBCConstants.DRIVER_NAME );

        }
        catch ( ClassNotFoundException e )
        {
            System.out.println( "Driver class not found" );
        }
    }
    public static Connection getConnection() throws SQLException
    {

        connection = DriverManager.getConnection( JDBCConstants.URL, JDBCConstants.USERNAME, JDBCConstants.PASSWORD );
        return connection;
    }
    public static void closeConnection( Connection con ) throws SQLException
    {
        if ( con != null )
        {
            con.close();
        }
    }
}
