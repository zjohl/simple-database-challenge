package turo.codexercise.command.data;

import org.junit.Before;
import org.junit.Test;
import turo.codeexercise.command.ICommand;
import turo.codeexercise.command.data.EndCommand;
import turo.codeexercise.controller.DatabaseController;
import turo.codeexercise.controller.IDatabaseController;
import turo.codeexercise.model.DatabaseModel;
import turo.codeexercise.model.IDatabaseModel;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Tests end command
 */
public class TestEndCommand {
    IDatabaseController mockController;
    IDatabaseModel mockModel;
    ICommand end;



    @Before
    public void Setup() {
        mockModel = mock(DatabaseModel.class);
        mockController = mock(DatabaseController.class);
        end = new EndCommand();
    }

    @Test
    public void testSetCallsSystemEnd() {
        // end.execute(mockModel);
        // We need to verify the system.exit() call
        // Mocking this seems like a poor approach
        // It's possible that there is a more convenient way to exit a program in a command,
        // if that is the case it could also be easier to test
    }

    @Test
    public void testEndIsDataCommand() {
        assert(end.isDataCommand());
    }

    @Test(expected=IllegalArgumentException.class)
    public void testExecuteOnController() {
        end.execute(mockController);
    }

    @Test
    public void testRollback() {
        // We want to test that the rollback command created is appropriate
        // For this we could try to mock the constructor of the rollback command
        // to make sure the arguments are correct
    }
}
