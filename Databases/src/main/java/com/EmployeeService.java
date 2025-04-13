/*
 * @file            Databases/src/main/java/com/EmployeeService.java
 * @description     Subclass of DB for executing CRUD operations on the database
 * @author          Jesse Peterson
 * @createTime      2025-04-08 21:06:34
 * @lastModified    2025-04-11 17:13:49
*/

package com;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeService extends DB {


    /**
     * Constructor
     */
    EmployeeService() {
        super();
        initialize();           //Establish Connection
    }

    /**
     * Add an employee to the database
     * @param name
     * @param email
     * @param department
     * @param salary
     */
    public void addEmployee(String name, String email, String department, double salary) {

        // Creates a new employee with args
        Employee employee = new Employee(name, email, department, salary);

        // Query string that is preped for a prepared statement
        String query = "INSERT INTO employees (name, email, department, salary) VALUES (?, ?, ?, ?)";

        // Create a prepared statement and set all the values to args
        try {
            
            PreparedStatement pStatement = connection.prepareStatement(query);
            pStatement.setString(1, employee.name);
            pStatement.setString(2, employee.email);
            pStatement.setString(3, employee.department);
            pStatement.setDouble(4, employee.salary);

            // Execute the prepared statement (Adding the employee)
            pStatement.executeUpdate();

            // Notify console of the addition
            System.out.println("Added employee: " + name);
        } catch (SQLException e) {
          e.printStackTrace();  
        }
    }

    /**
     * Remove an employee from the database based on id
     * @param id_
     */
    public void removeEmployee(int id_) {

        // Query string that is prepared for a prepared statement
        String query = "DELETE FROM employees WHERE id_ = ?";

        // Create the prepared statement and add the id to the statement
        try {
            PreparedStatement pStatement = connection.prepareStatement(query);
            pStatement.setInt(1, id_);

            // Execute the query and track the status
            int rowsAffected = pStatement.executeUpdate();

            // if more than 0 rows are affected then removal was a success
            if (rowsAffected > 0) {
                System.out.println("Removal Success!\n");
            } else {
                System.out.println("Removal: No employee found with provided id\n");
            }

        } catch (SQLException e) {
            System.err.println("Error removing employee");
            e.printStackTrace();
        }
    }
    
    /**
     * Remove an employee from the database based on their name
     * @param name
     */
    public void removeEmployee(String name) {

        // Query string that is prepared for a prepared statemen
        String query = "DELETE FROM employees WHERE name = ?";

        // Create the prepared statement and add the name to the string
        try {
            PreparedStatement pStatement = connection.prepareStatement(query);
            pStatement.setString(1, name);

            // Execute the query and track the status
            int rowsAffected = pStatement.executeUpdate();

            // If more than 0 rows are affected than the removal was a success
            if (rowsAffected > 0) {
                System.out.println("Removal Success!\n");
            } else {
                System.out.println("Removal: No employee found with provided id\n");
            }    

        } catch (SQLException e) {
            System.err.println("Error removing employee");
            e.printStackTrace();
        }
    }

    /**
     * Update an employee from the database
     * @param id_ employee to update
     * @param item the field to update
     * @param value the value to update to
     */
    public void updateEmployee(int id_, String item, String value) {

        // Query string prepared for args
        String query = "UPDATE employees SET " + item + " = ? WHERE id_ = ? ";

        // Only used if the item is salary
        // This is because salary is a double and not a String
        double newSalary = -1;
        
        // if the item to change is salary then parse to double
        try {
            if(item == "salary") {
                newSalary =  Double.parseDouble(value);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }


        
        try {

            // Create a prepared statement for the query
            PreparedStatement pStatement = connection.prepareStatement(query);

            //If the item to change is the salary, set that value in the query
            // Otherwise change the value to the string
            if (item == "salary") {
                pStatement.setDouble(1, newSalary);
            } else {
                pStatement.setString(1, value);
            }

            // Set the id_ for the employee in the query
            pStatement.setInt(2, id_);

            // execute the query and track the status
            int rowsAffected = pStatement.executeUpdate();

            // If more than 0 rows are affected then the update was a success
            if (rowsAffected > 0) {
                System.out.println("Update Success!\n");
            } else {
                System.out.println("Update: No employee found with provided id\n");
            }    


        } catch (SQLException e) {
            System.err.println("Error Updating employee");
            e.printStackTrace();
        }
    }



    /**
     * Retrieve an employee from any field excluding id_
     * @param item employee field
     * @param value what to search for in the field
     */
    public void getEmployee(String item, String value) {

        // Query string perepared for prepared statement
        String query = "SELECT * FROM employees WHERE " + item + " = ?";

        System.out.println("Fetching employee");

        try {
            // Created the prepared statement and add the value
            PreparedStatement pStatement = connection.prepareStatement(query);
            pStatement.setString(1, value);
    
            // Execute the query and store data in a set
            ResultSet set = pStatement.executeQuery();

            // Iterate over the set and return the employee information
            while (set.next()) {
                System.out.println(new Employee(set).toString());
                System.out.println();
            }
    
        } catch (SQLException e) {
            System.err.println("Error retrieving employee");
            e.printStackTrace();
        }

    }

    /**
     * Retrieve an employee from the database based on an id/int value
     * @param item field
     * @param value integer (Search term)
     */
    public void getEmployee(String item, int value) {

        // Query string pepared for the prepared statement
        String query = "SELECT * FROM employees WHERE " + item + " = ?";
        
        System.out.println("Fetching employee");

        try {

            // Creates the prepared statement and injects the value
            PreparedStatement pStatement = connection.prepareStatement(query);
            pStatement.setInt(1, value);
    
            // Execute the query and save the response as a Result Set
            ResultSet set = pStatement.executeQuery();
            
            // Iterate over the set and print the employee fields
            while (set.next()) {
                System.out.println(new Employee(set).toString());
                System.out.println();
            }
    
        } catch (SQLException e) {
            System.err.println("Error retrieving employee");
            e.printStackTrace();
        }
    }

    /**
     * Retrieves all of the employees in the database
     */
    public void getEmployees() {
        
        // Query string prepared for execution
        String query = "SELECT * FROM employees";

        try {

            // Create the statement and execute with the response stored into a Result Set
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(query);

            // Iterate over the set and print each employee
            while (set.next()) {
                System.out.println(new Employee(set).toString());
                System.out.println();
            }

        } catch (SQLException e) {
            System.err.println("Error retrieving employees:");
            e.printStackTrace();
        }
    }
    
    
}
