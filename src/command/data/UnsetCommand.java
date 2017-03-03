package turo.codeexercise.command.data;

import turo.codeexercise.command.Command;
import turo.codeexercise.model.IDatabaseModel;

/**
 * Represents a SET database command
 */
public class UnsetCommand extends ADataCommand {

    /**
     * Creates an UNSET database command
     *
     * @param name key of entry to unset
     */
    public UnsetCommand(String name) {
        super("UNSET");
        this.name = name;
    }

    /**
     * Executes command on provided database model
     *
     * @param model a database model to execute this command on
     * @return a string representing the previous value of this entry
     */
    public String execute(IDatabaseModel model) {
        model.removeEntry(this.name);
        return "";
    }

    /**
     * Creates a command to rollback this command
     *
     * @param model a database model to rollback these changes from
     * @return a command that will reverse the changes made by this command
     */
    public Command createRollback(IDatabaseModel model) {
        return new SetCommand(this.name, model.getEntry(this.name));
    }
}
