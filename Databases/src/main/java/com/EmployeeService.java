package com;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;

public class EmployeeService extends DB {

    EmployeeService() {
        super();
        initialize();    
    }

    public void addEmployee(int id_, String name, String email, String department, double salary) {
        Employee employee = new Employee(id_, name, email, department, salary);

        String query = "INSERT INTO employees (name, email, department, salary) VALUES (?, ?, ?, ?)";

        try {

            PreparedStatement pStatement = connection.prepareStatement(query);
            pStatement.setString(1, employee.name);
            pStatement.setString(2, employee.email);
            pStatement.setString(3, employee.department);
            pStatement.setDouble(4, employee.salary);

        } catch (SQLException e) {
          e.printStackTrace();  
        }
    }

    public void removeEmployee(int id_) {
        String query = "DELETE FROM employees WHERE id_ = (?)";

        try {
            PreparedStatement pStatement = connection.prepareStatement(query);
            pStatement.setInt(1, id_);
            ResultSet set = pStatement.executeQuery();

            System.out.println("Success: " + set.toString());
        } catch (SQLException e) {
            System.err.println("Error removing employee");
            e.printStackTrace();
        }
    }
    
    public void removeEmployee(String name) {
        String query = "DELETE FROM employees WHERE name = (?)";

        try {
            PreparedStatement pStatement = connection.prepareStatement(query);
            pStatement.setString(1, name);
            ResultSet set = pStatement.executeQuery();

            System.out.println("Success: " + set.toString());
        } catch (SQLException e) {
            System.err.println("Error removing employee");
            e.printStackTrace();
        }
    }
    //TODO update

    //TODO getter single

    //TODO getter aggregate
    
    
}
