package com;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;

import org.mariadb.jdbc.message.client.PrepareExecutePacket;

import com.google.gson.*;


public class DB {

    Path filePath = Paths.get("resources/dbUser.json");
    String dbURL;
    String username;
    String password;
    String dbName;
    
    protected Connection connection;



    
    DB () {

        // Initialize DB Credentials
        initializeCredentials();
        System.out.println(dbURL);
        System.out.println(username);
        System.out.println(password);
        System.out.println(dbName);
        
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

            try {
                if (statement != null) statement.close();
                if (connection != null) statement.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

        try {
            connection = DriverManager.getConnection(String.format("%s%s", dbURL, dbName), username, password);
            statement = connection.createStatement();


            String createTableQuery = """
                    CREATE TABLE IF NOT EXISTS employees(
                    id_ INT AUTO_INCREMENT PRIMARY KEY,
                    name VARCHAR(100),
                    email VARCHAR(100),
                    department VARCHAR(100),
                    salary DECIMAL(10, 2)
                    );
                    """;

            statement.executeUpdate(createTableQuery);
            System.out.println("Created the table successfully!");
        } catch (SQLException e) {
            System.err.println("Could not creat employee table");
            e.printStackTrace();
        } finally {
            
            try {
                if (statement != null) statement.close();
                if (connection != null) statement.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void initializeCredentials() {

        Gson gson = new Gson();
        JsonObject config;

        try (FileReader reader = new FileReader(filePath.toFile())) {
            config = gson.fromJson(reader, JsonObject.class);

            this.dbURL = config.get("dbURL").getAsString();
            this.username = config.get("username").getAsString();
            this.password = config.get("password").getAsString();
            this.dbName = config.get("dbName").getAsString();

        } catch (IOException e) {
            System.err.println("Error Reading the Config File");
            e.printStackTrace();
        }
    }

    public void initialize() {
        try {
            connection = DriverManager.getConnection(String.format("%s%s", dbURL, dbName), username, password);
            System.out.println("Connection Established!");
        } catch (SQLException e) {
            System.out.println("Error Establishing Connection to Database");
            e.printStackTrace();
        }
    }

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
