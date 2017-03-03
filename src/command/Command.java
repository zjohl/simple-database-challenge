package turo.codeexercise.command;

import turo.codeexercise.controller.IDatabaseController;
import turo.codeexercise.model.IDatabaseModel;

/**
 * Represnts a basic command
 *
 * Commands are essentially blank, as their methods can all be safely called without any side-effects
 */
public class Command implements ICommand {

    protected String type;
    protected String name;
    protected String value;

    /**
     * Creates command from provided fields
     *
     * @param type type of command
     */
    public Command(String type) {
        this.type = type;
    }

    /**
     * Executes command on provided database model
     *
     * @param model a database model to execute this command on
     * @return a string representing the output of this command
     */
    public String execute(IDatabaseModel model) {
        return "";
    }

    /**
     * Executes command on provided database controller
     *
     * @param controller a database controller to execute this command on
     * @return a string representing the output of this command
     */
    public String execute(IDatabaseController controller) {
        return "";
    }


    /**
     * Creates a command to rollback this command
     *
     * @param model a database model to rollback these changes from
     * @return a command that will reverse the changes made by this command
     */
    public Command createRollback(IDatabaseModel model) {
        return new Command("");
    }

    /**
     * Indicates whether or not this command is a data
     *
     * @return true if the command type corresponds to a data command or false otherwise
     */
    public boolean isDataCommand() {
        return false;
    }
}
