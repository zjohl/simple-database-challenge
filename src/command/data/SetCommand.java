package turo.codeexercise.command.data;

import turo.codeexercise.command.Command;
import turo.codeexercise.model.IDatabaseModel;

/**
 * Represents a SET database command
 */
public class SetCommand extends ADataCommand {

    /**
     * Creates a SET database command
     *
     * @param name key of entry to set
     * @param value value of entry to set
     */
    public SetCommand(String name, String value) {
        super("SET");
        this.name = name;
        this.value = value;
    }

    /**
     * Executes command on provided database model
     *
     * @param model a database model to execute this command on
     * @return a string representing previous value of this entry, if any
     */
    public String execute(IDatabaseModel model) {
        model.addEntry(this.name, this.value);
        return "";
    }

    /**
     * Creates a command to rollback this command
     *
     * @param model a database model to rollback these changes from
     * @return a command that will reverse the changes made by this command
     */
    public Command createRollback(IDatabaseModel model) {
        if(model.getEntry(this.name) != null) {
            return new SetCommand(this.name, model.getEntry(this.name));
        } else {
            return new UnsetCommand(this.name);
        }
    }
}
