/*
 * @file            Databases/src/main/java/com/DB.java
 * @description     
 * @author          Jesse Peterson
 * @createTime      2025-04-08 16:56:17
 * @lastModified    2025-04-12 16:53:55
*/

package com;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;

import com.google.gson.*;


public class DB {

    // Setting a path object to ensure the file is created in the proper directory
    Path filePath = Paths.get("resources/dbUser.json");

    // Class fields
    private String dbURL;
    private String username;
    private String password;
    private String dbName;
    
    // Connection object, accessible to all subclasses so they can execute queries
    protected Connection connection;


    /**
     * Default constructor
     * 1. Fetches the credentials if unavailable
     * 2. tries to establish connection and creates the DB if not already
     * 3. trues to create the table if it doesn't exist
     */
    DB () {

        // Initialize DB Credentials
        initializeCredentials();
        
        // Initialize the connection and statement objects
        connection = null;
        Statement statement = null;


        try {
            // Connect to the database withough specifying a database
            connection = DriverManager.getConnection(dbURL, username, password);
            statement = connection.createStatement();

            // Check validity of the database
            String checkDatabaseQuery = "SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = '" + dbName + "'";
            ResultSet resultSet = statement.executeQuery(checkDatabaseQuery);

            // Make the DB if it doesn't exist already
            if(!resultSet.next()) {
                String createDatabaseQuery = "CREATE DATABASE " + dbName;
                statement.executeUpdate(createDatabaseQuery);
                System.out.println("Database: " + dbName +  " Created Successfuly");
            } else {
                System.out.println("Database: " + dbName + " Already Exists");
            }

        } catch(Exception e) {
            e.printStackTrace();
        } finally {

            // Close the statement and connection if they are not null
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

        try {

            // Establish connection and prepare for a new statement
            connection = DriverManager.getConnection(String.format("%s%s", dbURL, dbName), username, password);
            statement = connection.createStatement();


            // Query for the employee table
            String createTableQuery = """
                    CREATE TABLE IF NOT EXISTS employees(
                    id_ INT AUTO_INCREMENT PRIMARY KEY,
                    name VARCHAR(100),
                    email VARCHAR(100),
                    department VARCHAR(100),
                    salary DECIMAL(10, 2)
                    );
                    """;

            // Execute the query and notify the user upon completion
            statement.executeUpdate(createTableQuery);
            System.out.println("Created the table successfully!");

        } catch (SQLException e) {

            System.err.println("Could not creat employee table");
            e.printStackTrace();

        } finally {
            
            // Close the statement and connection if they are not null
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *  retrieves the DB credentials from the dbUser.json file
     * reads for, Url, Username, Password, and table name
     */
    private void initializeCredentials() {

        // Creates a new json object
        Gson gson = new Gson();
        JsonObject config;

        // Creates a reader then sets the config object to the file contents
        try (FileReader reader = new FileReader(filePath.toFile())) {
            config = gson.fromJson(reader, JsonObject.class);

            // Search for 'dbUrl', 'username', 'password' and 'dbName'
            this.dbURL = config.get("dbURL").getAsString();
            this.username = config.get("username").getAsString();
            this.password = config.get("password").getAsString();
            this.dbName = config.get("dbName").getAsString();

        } catch (IOException e) {
            System.err.println("Error Reading the Config File");
            e.printStackTrace();
        }
    }

    /**
     * established connection to the 'connection' object
     */
    public void initialize() {
        try {
            connection = DriverManager.getConnection(String.format("%s%s", dbURL, dbName), username, password);
            System.out.println("Connection Established!");
        } catch (SQLException e) {
            System.out.println("Error Establishing Connection to Database");
            e.printStackTrace();
        }
    }

    /**
     * Closes connection to the 'connection' object
     */
    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection Closed.");
            }
        } catch (SQLException e) {
            System.out.println("Unable to Close Connection");
            e.printStackTrace();
        }
    }

    
}
