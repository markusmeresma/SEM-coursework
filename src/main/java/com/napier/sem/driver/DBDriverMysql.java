package com.napier.sem.driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBDriverMysql {

    private static final int MAX_TRIES = 100;

    private static final String USER = "root";
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";

    private String dbUrl;
    private String password;

    private Connection conn;

    public DBDriverMysql(String dbUrl, String password) {
        this.conn = null;
        this.password = password;
        this.dbUrl = dbUrl;
    }

    public Connection getConn() {
        return conn;
    }

    /**
     * Connect to MySQL database.
     */
    public void connect() {
        try
        {
            // Load Database driver
            Class.forName(DB_DRIVER);
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        // Connection to the database
        for (int i = 0; i < MAX_TRIES; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                Thread.sleep(10000);
                // Connect to database
                conn = DriverManager.getConnection(dbUrl, USER, password);
                System.out.println("Successfully connected");

                Thread.sleep(10000);
                // Exit for loop
                break;
            }
            catch (SQLException sqlException)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqlException.getMessage());
            }
            catch (InterruptedException interruptedException)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from MySQL database.
     */
    public void disconnect() {
        if (conn != null)
        {
            try
            {
                conn.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

}
