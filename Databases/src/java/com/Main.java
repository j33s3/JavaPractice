package Databases.src.java.com;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Scanner;

import java.nio.file.Paths;
import com.google.gson;

public class Main {

    private static String filePath = "resources/dbUser.json";
    
    public static void main (String[] args) {
        // Create file if it does not exist
        File f = new File(Paths.get(filePath).toFile());

        if (!f.exists()) {
            f.createNewFile();
            getDatabaseUser();
        } 


    }

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
        dbURL = scanner.next();

        System.out.print("Please Enter the Username: ");
        username = scanner.next();

        System.out.print("Please Enter the Password: ");
        password = scanner.next();

        System.out.print("Please Enter the dbName: ");
        dbName = scanner.next();

        // JSON object that stores variables
        class DatabaseConfig {
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

        // Creating new config
        DatabaseConfig config = new DatabaseConfig(dbURL, username, password, dbName);

        // Write the variables to the json file
        try (FileWriter writer = new FileWriter(Paths.get(filePath).toFile())) {
            gson.toJson(config, writer);
            System.out.println("Saved Configuration to dbUser.json");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
