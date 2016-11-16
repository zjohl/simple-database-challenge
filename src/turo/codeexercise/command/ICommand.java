package turo.codeexercise.command;

import turo.codeexercise.model.IDatabaseModel;
import turo.codeexercise.controller.IDatabaseController;


public interface ICommand {

    /**
     * Executes command on provided database model
     *
     * @param model a database model to execute this command on
     * @return a string representing the output of this command
     */
    public String execute(IDatabaseModel model);

    /**
     * Executes command on provided database controller
     *
     * @param controller a database controller to execute this command on
     * @return a string representing the output of this command
     */
    public String execute(IDatabaseController controller);

    /**
     * Creates a command to rollback this command
     *
     * @param model a database model to rollback these changes from
     * @return a command that will reverse the changes made by this command
     */
    public Command createRollback(IDatabaseModel model);

    /**
     * Indicates whether or not this command is a data
     *
     * @return true if the command type corresponds to a data command or false otherwise
     */
    public boolean isDataCommand();
}
