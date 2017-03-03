package turo.codeexercise.controller;

/**
 * Receives commands form the socket and converts it into commands for the model
 */
public interface IDatabaseController {

    /**
     * Executes the given command and returns the appropriate output
     *
     * @param command a string containing a single database command
     * @return a string containing information requested by the user, or to indicate status
     */
    String executeCommand(String command);

    /**
     * Creates a new transaction block
     */
    void createTransaction();

    /**
     * Rolls back the changes made by the last transaction
     */
    void rollbackTransaction();

    /**
     * Closes all open transations and applies their changes
     */
    void commitTransaction();
}
