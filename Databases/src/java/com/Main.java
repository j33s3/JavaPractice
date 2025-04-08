package Databases.src.java.com;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Scanner;

public class Main {
    
    public static void main (String[] args) {

    }

    private void getDatabaseUser () {
        Scanner scanner = new Scanner(System.in);

        File f = new File("./dbUser.json");

        try {
            f.createNewFile();
        } 
        catch (IOException e) {
            System.err.println(e);
        }

        try {
            BufferedWriter bf = new BufferedWriter(new FileWriter("./dbUser.json"));
            
        }
    }
    
}
