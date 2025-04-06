package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main (String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 55,  75000),
            new Employee("Bob", 23, 48000),
            new Employee("Charlie", 40, 90000),
            new Employee("David", 35, 55000),
            new Employee("Eva", 32, 120000)
        );

        //Filter the employees earning more than 50,000 and sort by salary using streams
        List<Employee> filteredAndSortedEmployees = employees.stream()
            .filter(employee -> employee.getSalary() > 50000)
            .sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
            .collect(Collectors.toList());


        filteredAndSortedEmployees.forEach(System.out::println);
    }
}