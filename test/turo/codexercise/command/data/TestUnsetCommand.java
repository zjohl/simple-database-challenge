package turo.codexercise.command.data;

import org.junit.Before;
import org.junit.Test;
import turo.codeexercise.command.ICommand;
import turo.codeexercise.command.data.UnsetCommand;
import turo.codeexercise.controller.DatabaseController;
import turo.codeexercise.controller.IDatabaseController;
import turo.codeexercise.model.DatabaseModel;
import turo.codeexercise.model.IDatabaseModel;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Tests unset command
 */
public class TestUnsetCommand {

    IDatabaseController mockController;
    IDatabaseModel mockModel;
    ICommand unset;


    @Before
    public void Setup() {
        mockModel = mock(DatabaseModel.class);
        mockController = mock(DatabaseController.class);
        unset = new UnsetCommand("a");
    }

    @Test
    public void testUnsetCallsRemoveEntry() {
        unset.execute(mockModel);
        verify(mockModel).removeEntry("a");
    }

    @Test
    public void testUnsetIsDataCommand() {
        assert(unset.isDataCommand());
    }

    @Test(expected=IllegalArgumentException.class)
    public void testExecuteOnController() {
        unset.execute(mockController);
    }

    @Test
    public void testRollback() {
        // We want to test that the rollback command created is appropriate
        // For this we could try to mock the constructor of the rollback command
        // to make sure the arguments are correct
    }
}
