package Databases.src.java.com;

import java.sql.*;

public class DB {

    String db_url = "jdbc:mysql://localhost:3306/";
    String username = "guest";
    String password = "password123";
    String db_name = "practice";


    
    DB () {
        Connection connection = null;
        Statement statement = null;

        try {
            //Connect to the database withough specifying a database
            connection = DriverManager.getConnection(db_url, username, password);
            statement = connection.createStatement();

            //Check validity of the database
            String checkDatabaseQuery = "SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = '" + db_name + "'";
            ResultSet resultSet = statement.executeQuery(checkDatabaseQuery);

            if(!resultSet.next()) {
                String createDatabaseQuery = "CREATE DATABASE " + db_name;
                statement.executeQuery(createDatabaseQuery);
                System.out.println("Database: " + db_name +  "Created Successfuly");
            } else {
                System.out.println("Database: " + db_name + "Created Successfully");
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
    }

    
}
