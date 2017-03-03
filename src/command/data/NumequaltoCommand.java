package turo.codeexercise.command.data;

import turo.codeexercise.command.Command;
import turo.codeexercise.model.IDatabaseModel;

/**
 * Represents a SET database command
 */
public class NumequaltoCommand extends ADataCommand {

    /**
     * Creates a NUMEQUALTO database command
     *
     * @param value value to count entries of
     */
    public NumequaltoCommand(String value) {
        super("NUMEQUALTO");
        this.value = value;
    }

    /**
     * Executes command on provided database model
     *
     * @param model a database model to execute this command on
     * @return a string representing the previous value of this entry
     */
    public String execute(IDatabaseModel model) {
        return Integer.toString(model.numValue(this.value));
    }
}
