package com;
public class Employee {
    int id_;
    String name;
    String email;
    String department;
    double salary;

    Employee(int id_, String name, String email, String department, double salary) {
        this.id_ = id_;
        this.name = name;
        this.email = email;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + id_ + "\nName: " + name + "\nEmail: " + email + "\nDepartment: " + department + "\nSalary: " + salary;
    }
}
