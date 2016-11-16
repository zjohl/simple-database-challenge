package turo.codexercise.command.data;

import org.junit.Before;
import org.junit.Test;
import turo.codeexercise.command.ICommand;
import turo.codeexercise.command.data.NumequaltoCommand;
import turo.codeexercise.controller.DatabaseController;
import turo.codeexercise.controller.IDatabaseController;
import turo.codeexercise.model.DatabaseModel;
import turo.codeexercise.model.IDatabaseModel;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Tests the numequalto command
 */
public class TestNumequaltoCommand {

    IDatabaseController mockController;
    IDatabaseModel mockModel;
    ICommand numequalto;


    @Before
    public void Setup() {
        mockModel = mock(DatabaseModel.class);
        mockController = mock(DatabaseController.class);
        numequalto = new NumequaltoCommand("10");
    }

    @Test
    public void testNumequalCallsNumValue() {
        numequalto.execute(mockModel);
        verify(mockModel).numValue("10");
    }

    @Test
    public void testNumEqualIsDataCommand() {
        assert(numequalto.isDataCommand());
    }

    @Test(expected=IllegalArgumentException.class)
    public void testExecuteOnController() {
        numequalto.execute(mockController);
    }

    @Test
    public void testRollback() {
        // We want to test that the rollback command created is appropriate
        // For this we could try to mock the constructor of the rollback command
        // to make sure the arguments are correct
    }
}
