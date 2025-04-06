package Java8;

import java.util.Arrays;
import java.util.List;

public class Employee {
    private String name;
    private int age;
    private int salary;

    Employee(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }


    public List<Object> getEmployee() {
        return Arrays.asList(name, age, salary);
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nAge: " + age + "\nSalary: $" + salary;
    }
}
