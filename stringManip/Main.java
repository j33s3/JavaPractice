package stringManip;

import java.util.Scanner;

public class Main {
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Please provide a pragraph of text!");
        String input = scanner.nextLine();
        input = input.trim();

        StringBuilder text = new StringBuilder(input);

        System.out.println("Converting Paragraph to Lower Case...\n");
        System.out.println(convertInputToLower(text));

        System.out.println("\nGetting the Word Count...");
        System.out.println(getWordCount(text));

        System.out.println("\nReplacing All Spaces With Underscores...");
        System.out.println(spacesToUnder(text));


        scanner.close();
    }


    /**
     * Converts entire string to lowercase then returns it
     * @param inputString
     * @return
     */
    private static String convertInputToLower(StringBuilder inputString) {
        String outputString = inputString.toString().toLowerCase();
        return outputString;
    }

    /**
     * Gets the total number of words in the paragraph
     * @param inputString
     * @return
     */
    private static int getWordCount(StringBuilder inputString) {
        int count = 1;
        for (int i = 0; i < inputString.length(); i++) {
            if(inputString.charAt(i) == ' ') {
                count++;
            }
        }

        return count;
    }

    /**
     * Replaces all the spaces in the paragraph to underscores
     * @param inputString
     * @return
     */
    private static String spacesToUnder(StringBuilder inputString) {

        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == ' ') {
                inputString.setCharAt(i, '_');
            }
        }
        return inputString.toString();
    }
}
