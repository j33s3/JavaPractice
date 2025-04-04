package FileHandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    String fileName;


    /**
     * Gets the filename and creates the file if it does not exist
     * @param fileName
     */
    FileManager(String fileName) {
        this.fileName = fileName;

        // Creates a new file if it does not exist
        File file = new File(fileName);

        try {
            file.createNewFile();
        }
        catch (IOException e) {
            System.err.println(e);
        }

    }

    /**
     *  Sets the text of the file
     * @param text
     */
    public void setText(String text) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(text);
            writer.close();
        }
        catch (IOException e) {
            System.err.println(e);
        }


    }

    /**
     * Returns The text of the file
     * @return
     */
    public String getText() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String content = reader.readLine();
            reader.close();
            return content;

        }
        catch (IOException e) {
            System.err.println(e);
            return null;
        }
    }

}
