package turo.codeexercise.command.data;

import turo.codeexercise.command.Command;
import turo.codeexercise.model.IDatabaseModel;

/**
 * Represents a GET database command
 */
public class GetCommand extends ADataCommand {

    /**
     * Creates a GET database command
     *
     * @param name key of entries to retrieve
     */
    public GetCommand(String name) {
        super("GET");
        this.name = name;
    }

    /**
     * Executes command on provided database model
     *
     * @param model a database model to execute this command on
     * @return a the value correspindign to the provided key in the database
     */
    public String execute(IDatabaseModel model) {
        String output = model.getEntry(this.name);
        if (output == null) {
            return "NULL";
        } else {
            return output;
        }
    }
}