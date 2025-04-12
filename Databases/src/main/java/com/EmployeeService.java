package com;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeService extends DB {

    EmployeeService() {
        super();
        initialize();    
    }

    public void addEmployee(String name, String email, String department, double salary) {
        Employee employee = new Employee(name, email, department, salary);

        String query = "INSERT INTO employees (name, email, department, salary) VALUES (?, ?, ?, ?)";

        try {
            
            PreparedStatement pStatement = connection.prepareStatement(query);
            pStatement.setString(1, employee.name);
            pStatement.setString(2, employee.email);
            pStatement.setString(3, employee.department);
            pStatement.setDouble(4, employee.salary);

            pStatement.executeUpdate();

            System.out.println("Added employee: " + name);
        } catch (SQLException e) {
          e.printStackTrace();  
        }
    }

    public void removeEmployee(int id_) {
        String query = "DELETE FROM employees WHERE id_ = ?";

        try {
            PreparedStatement pStatement = connection.prepareStatement(query);
            pStatement.setInt(1, id_);
            int rowsAffected = pStatement.executeUpdate();

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
    
    public void removeEmployee(String name) {
        String query = "DELETE FROM employees WHERE name = ?";

        try {
            PreparedStatement pStatement = connection.prepareStatement(query);
            pStatement.setString(1, name);
            int rowsAffected = pStatement.executeUpdate();

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

    public void updateEmployee(int id_, String item, String value) {
        String query = "UPDATE employees SET " + item + " = ? WHERE id_ = ? ";
        double newSalary = -1;
        
        try {
            if(item == "salary") {
                newSalary =  Double.parseDouble(value);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }


        try {
            PreparedStatement pStatement = connection.prepareStatement(query);
            if (item == "salary") {
                pStatement.setDouble(1, newSalary);
            } else {
                pStatement.setString(1, value);
            }
            pStatement.setInt(2, id_);

            int rowsAffected = pStatement.executeUpdate();

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



    public void getEmployee(String item, String value) {
        String query = "SELECT * FROM employees WHERE " + item + " = ?";

        System.out.println("Fetching employee");

        try {
            PreparedStatement pStatement = connection.prepareStatement(query);
            pStatement.setString(1, value);
    
            ResultSet set = pStatement.executeQuery();

            while (set.next()) {
                System.out.println(new Employee(set).toString());
                System.out.println();
            }
    
        } catch (SQLException e) {
            System.err.println("Error retrieving employee");
            e.printStackTrace();
        }

    }

    public void getEmployee(String item, int value) {
        String query = "SELECT * FROM employees WHERE " + item + " = ?";
        
        System.out.println("Fetching employee");

        try {
            PreparedStatement pStatement = connection.prepareStatement(query);
            pStatement.setInt(1, value);
    
            ResultSet set = pStatement.executeQuery();
            
            while (set.next()) {
                System.out.println(new Employee(set).toString());
                System.out.println();
            }
    
        } catch (SQLException e) {
            System.err.println("Error retrieving employee");
            e.printStackTrace();
        }
    }

    public void getEmployees() {
        String query = "SELECT * FROM employees";

        try {
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(query);

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
