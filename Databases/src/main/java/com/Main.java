package com;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.google.gson.*;

public class Main {

    private static Path filePath = Paths.get("resources/dbUser.json");
    
    public static void main (String[] args) {
        // Create file if it does not exist
        File f = filePath.toFile();


        if (!f.exists() || f.length() == 0) {

            try {
               f.createNewFile();
            } 
            catch (IOException e) {
                e.printStackTrace();
            }

            getDatabaseUser();
        } 

        connectToDB();
    }

    private static void connectToDB() {
        EmployeeService employeeDB = new EmployeeService();

        employeeDB.addEmployee("Joyce", "Joyce@company.net", "Merch", 30000.00);
        employeeDB.addEmployee("Brian", "Brian@company.net", "IT",  89000.00);
        employeeDB.addEmployee("Lucy", "Lucy@company.net", "Inventory", 49500.00);
        employeeDB.addEmployee("Cheri", "Cheri@company.net", "Senior Management", 300000.00);
        employeeDB.addEmployee("Harold", "Harold@company.net", "Acounting", 125000.00);

        employeeDB.getEmployees();

        employeeDB.updateEmployee(1, "salary", "100000.00");

        employeeDB.getEmployee("name",  "Joyce");

        employeeDB.removeEmployee(1);

        employeeDB.getEmployees();

    }


    /**
     * Retrieves the database info from the user if needed;
     */
    private static void getDatabaseUser () {
        Scanner scanner = new Scanner(System.in);

        Gson gson = new Gson();

        // input variables;
        String dbURL;
        String username;
        String password;
        String dbName;

        // Retreiving variables
        System.out.print("Please Enter the MySQL URL: ");
        dbURL = scanner.nextLine();

        System.out.print("Please Enter the Username: ");
        username = scanner.nextLine();

        System.out.print("Please Enter the Password: ");
        password = scanner.nextLine();

        System.out.print("Please Enter the dbName: ");
        dbName = scanner.nextLine();

        scanner.close();

        // Creating new config
        DatabaseConfig config = new DatabaseConfig(dbURL, username, password, dbName);

        // Write the variables to the json file
        try (FileWriter writer = new FileWriter(filePath.toFile())) {
            gson.toJson(config, writer);
            System.out.println("Saved Configuration to dbUser.json");
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    // JSON object for serialization
    static class DatabaseConfig {
        String dbURL;
        String username;
        String password;
        String dbName;
    
        DatabaseConfig (String dbURL, String username, String password, String dbName) {
            this.dbURL = dbURL;
            this.username = username;
            this.password = password;
            this.dbName = dbName;
        }
    
    }
    
}



