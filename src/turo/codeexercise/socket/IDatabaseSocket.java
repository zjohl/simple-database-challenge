package turo.codeexercise.socket;

/**
 * Parses input into controller commands
 */
public interface IDatabaseSocket {

    /**
     * Creates an input string command
     *
     * @return a strign representing a database command
     */
    String getCommand();

    /**
     * Displays provided output to teh user
     *
     * @param output a string representing the output to display to the user
     */
    void displayOutput(String output);
}
