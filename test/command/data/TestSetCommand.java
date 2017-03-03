package turo.codexercise.command.data;

import org.junit.Before;
import org.junit.Test;
import turo.codeexercise.command.ICommand;
import turo.codeexercise.command.data.SetCommand;
import turo.codeexercise.command.data.UnsetCommand;
import turo.codeexercise.controller.*;
import turo.codeexercise.model.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Tests the SetCommand Class
 */
public class TestSetCommand {

    IDatabaseController mockController;
    IDatabaseModel mockModel;
    ICommand set;


    @Before
    public void Setup() {
        mockModel = mock(DatabaseModel.class);
        mockController = mock(DatabaseController.class);
        set = new SetCommand("a", "10");
    }

    @Test
    public void testSetCallsAddEntry() {
        set.execute(mockModel);
        verify(mockModel).addEntry("a", "10");
    }

    @Test
    public void testSetIsDataCommand() {
        assert(set.isDataCommand());
    }

    @Test(expected=IllegalArgumentException.class)
    public void testExecuteOnController() {
        set.execute(mockController);
    }

    @Test
    public void testRollback() {
        // We want to test that the rollback command created is appropriate
        // For this we could try to mock the constructor of the rollback command
        // to make sure the arguments are correct
    }
}
