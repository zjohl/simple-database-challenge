package turo.codeexercise.command.control;

import turo.codeexercise.command.Command;
import turo.codeexercise.model.IDatabaseModel;

/**
 * Represents a control command
 *
 * Control commands can only be executed on a databse controller
 */

abstract class AControlCommand extends Command {

    public AControlCommand(String type) {
        super(type);
    }

    /**
     * Executes command on provided database model

     * Throws an exception because control commands do not act on the model
     */
    public String execute(IDatabaseModel model) {
        throw new IllegalArgumentException("Passed a model into a control command");
    }
}
