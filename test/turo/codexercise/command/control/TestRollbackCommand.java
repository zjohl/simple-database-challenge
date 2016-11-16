package turo.codexercise.command.control;

import org.junit.Before;
import org.junit.Test;
import turo.codeexercise.command.ICommand;
import turo.codeexercise.command.control.RollbackCommand;
import turo.codeexercise.controller.DatabaseController;
import turo.codeexercise.controller.IDatabaseController;
import turo.codeexercise.model.DatabaseModel;
import turo.codeexercise.model.IDatabaseModel;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Tests the rollback command
 */
public class TestRollbackCommand {

    IDatabaseController mockController;
    IDatabaseModel mockModel;
    ICommand rollback;


    @Before
    public void Setup() {
        mockModel = mock(DatabaseModel.class);
        mockController = mock(DatabaseController.class);
        rollback = new RollbackCommand();
    }

    @Test
    public void testRollbackCallsRollbackTransaction() {
        rollback.execute(mockController);
        verify(mockController).rollbackTransaction();
    }

    @Test
    public void testRollbackIsNotDataCommand() {
        assertFalse(rollback.isDataCommand());
    }

    @Test(expected=IllegalArgumentException.class)
    public void testExecuteOnModel() {
        rollback.execute(mockModel);
    }

    @Test
    public void testRollback() {
        // We want to test that the rollback command created is appropriate
        // For this we could try to mock the constructor of the rollback command
        // to make sure the arguments are correct
    }
}
