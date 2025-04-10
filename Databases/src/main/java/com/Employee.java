package com;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Employee {
    int id_;
    String name;
    String email;
    String department;
    double salary;

    Employee(String name, String email, String department, double salary) {
        this.name = name;
        this.email = email;
        this.department = department;
        this.salary = salary;
    }

    Employee(ResultSet set) {

        try {

            
            id_ = set.getInt("id_");
            name = set.getString("name");
            email = set.getString("email");
            department = set.getString("department");
            salary = set.getDouble("salary");

        } catch (SQLException e) {
            System.out.println("Error Reading Data Set");
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return "ID: " + id_ + "\nName: " + name + "\nEmail: " + email + "\nDepartment: " + department + "\nSalary: " + salary;
    }
}
