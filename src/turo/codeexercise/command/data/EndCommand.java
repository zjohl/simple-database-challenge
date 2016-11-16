package turo.codeexercise.command.data;

import turo.codeexercise.command.Command;
import turo.codeexercise.model.IDatabaseModel;

/**
 * Represents an END database command
 */
public class EndCommand extends ADataCommand {

    /**
     * Creates an END database command
     */
    public EndCommand() {
        super("END");
    }

    /**
     * Exits program
     *
     * @param model a database model to execute this command on
     * @return a string representing previous value of this entry, if any
     */
    public String execute(IDatabaseModel model) {
        System.exit(0);
        return "Exiting Program";
    }
}
