/*
 * @file            Databases/src/main/java/com/Employee.java
 * @description     
 * @author          Jesse Peterson
 * @createTime      2025-04-08 21:06:34
 * @lastModified    2025-04-09 22:06:19
*/

package com;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Employee {

    // employee fields
    int id_;
    String name;
    String email;
    String department;
    double salary;

    /**
     * Initializes variables for the employee
     * id_ is procured from the database via auto_increment
     * @param name employee name
     * @param email employee email
     * @param department employee working department
     * @param salary employee salary
     */
    Employee(String name, String email, String department, double salary) {
        this.name = name;
        this.email = email;
        this.department = department;
        this.salary = salary;
    }

    /**
     * Constructor for reading employee from DB using ResultSet
     * @param set Employee information set
     */
    Employee(ResultSet set) {

        // Parse through the set and extract item information
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

    /**
     * @return String, employee information formatted vertically
     */
    @Override
    public String toString() {
        return "ID: " + id_ + "\nName: " + name + "\nEmail: " + email + "\nDepartment: " + department + "\nSalary: " + salary;
    }
}
