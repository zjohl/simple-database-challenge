package turo.codexercise.command.data;

import org.junit.Before;
import org.junit.Test;
import turo.codeexercise.command.ICommand;
import turo.codeexercise.command.data.GetCommand;
import turo.codeexercise.controller.DatabaseController;
import turo.codeexercise.controller.IDatabaseController;
import turo.codeexercise.model.DatabaseModel;
import turo.codeexercise.model.IDatabaseModel;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Tests get command
 */
public class TestGetCommand {

    IDatabaseController mockController;
    IDatabaseModel mockModel;
    ICommand get;


    @Before
    public void Setup() {
        mockModel = mock(DatabaseModel.class);
        mockController = mock(DatabaseController.class);
        get = new GetCommand("a");
    }

    @Test
    public void testGetCallsGetEntry() {
        get.execute(mockModel);
        verify(mockModel).getEntry("a");
    }

    @Test
    public void testGetIsDataCommand() {
        assert(get.isDataCommand());
    }

    @Test(expected=IllegalArgumentException.class)
    public void testExecuteOnController() {
        get.execute(mockController);
    }

    @Test
    public void testRollback() {
        // We want to test that the rollback command created is appropriate
        // For this we could try to mock the constructor of the rollback command
        // to make sure the arguments are correct
    }
}
