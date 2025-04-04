package FileHandling;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(">");

        String input = scanner.nextLine();

        FileManager fm = new FileManager("./file.txt");

        fm.setText(input);
        System.out.println(fm.getText());


        scanner.close();
    }

}