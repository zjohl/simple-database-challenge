package turo.codeexercise.command.control;

import turo.codeexercise.command.control.AControlCommand;
import turo.codeexercise.controller.IDatabaseController;

/**
 * Created by Zamir on 2016-11-15.
 */
public class RollbackCommand extends AControlCommand {

    /**
     * Creates an ROLLBACK database command
     */
    public RollbackCommand() {
        super("ROLLBACK");
    }

    /**
     * Executes command on provided database controller
     *
     * @param controller a database controller to execute this command on
     * @return whether ot not the transaction could be commited
     */
    public String execute(IDatabaseController controller) {
        try {
            controller.rollbackTransaction();
            return "";
        } catch (RuntimeException e) {
            return "NO TRANSACTION";
        }
    }
}
