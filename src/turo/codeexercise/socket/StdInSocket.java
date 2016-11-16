package turo.codeexercise.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.IOException;

public class StdInSocket implements IDatabaseSocket {
    BufferedReader reader;

    /**
     * Constructor for a command line stdin reader
     */
    public StdInSocket() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * Constructor for a file reader
     */
    public StdInSocket(String filename) {
        try {
            this.reader = new BufferedReader(new FileReader(filename));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Creates an input string command
     *
     * @return a string representing a database command
     */
    public String getCommand() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Displays provided output to the user
     *
     * @param output a string representing the output to display to the user
     */
    public void displayOutput(String output) {
        if(!output.equals("")) {
            System.out.println(output);
        }
    }
}
