package turo.codeexercise.command.data;

import turo.codeexercise.command.Command;
import turo.codeexercise.controller.IDatabaseController;

/**
 * Represents a data command
 *
 * Data commands can only be executed on a database model
 */
abstract class ADataCommand extends Command {

    public ADataCommand(String type) {
        super(type);
    }

    /**
     * Executes command on provided database controller
     *
     * @param controller a database controller to execute this command on
     * @return a string representing the output of this command
     */
    public String execute(IDatabaseController controller) {
        throw new IllegalArgumentException("Passed a controller into a non control command");
    }

    /**
     * Indicates whether or not this command is a data command
     *
     * @return true if the command type corresponds to a data command or false otherwise
     */
    public boolean isDataCommand() {
        return true;
    }
}
