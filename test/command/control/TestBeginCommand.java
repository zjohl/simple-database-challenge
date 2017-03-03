package turo.codexercise.command.control;

import org.junit.*;
import turo.codeexercise.command.ICommand;
import turo.codeexercise.command.control.BeginCommand;
import turo.codeexercise.controller.DatabaseController;
import turo.codeexercise.controller.IDatabaseController;
import turo.codeexercise.model.DatabaseModel;
import turo.codeexercise.model.IDatabaseModel;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Tests the begin command
 */

public class TestBeginCommand {

    IDatabaseController mockController;
    IDatabaseModel mockModel;
    ICommand begin;


    @Before
    public void Setup() {
        mockModel = mock(DatabaseModel.class);
        mockController = mock(DatabaseController.class);
        begin = new BeginCommand();
    }

    @Test
    public void testBeginCallsCreateTransaction() {
        begin.execute(mockController);
        verify(mockController).createTransaction();
    }

    @Test
    public void testBeginIsNotDataCommand() {
        assertFalse(begin.isDataCommand());
    }

    @Test(expected=IllegalArgumentException.class)
    public void testExecuteOnModel() {
        begin.execute(mockModel);
    }

    @Test
    public void testRollback() {
        // We want to test that the rollback command created is appropriate
        // For this we could try to mock the constructor of the rollback command
        // to make sure the arguments are correct
    }
}
