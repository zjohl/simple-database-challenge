package turo.codexercise.controller;

import org.junit.*;
import turo.codeexercise.command.*;
import turo.codeexercise.command.data.*;
import turo.codeexercise.command.control.*;
import turo.codeexercise.controller.DatabaseController;
import turo.codeexercise.model.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TestDatabaseController {

    DatabaseController controller;
    IDatabaseModel mockModel = mock(DatabaseModel.class);
    ICommand mockSet = mock(SetCommand.class);
    ICommand mockGet= mock(GetCommand.class);


    @Before
    public void Setup() {
        controller = new DatabaseController(mockModel);
    }

    @Test
    public void testExecuteDataCommands() {
        controller.executeCommand("SET a 10");
        verify(mockSet).execute(mockModel);
    }

    @Test
    public void testExecuteControlCommands() {
        controller.executeCommand("SET a 10");
        verify(mockSet).execute(mockModel);
    }

    @Test
    public void testGenerateCommand() {

    }

    @Test
    public void testCreateTransaction() {

    }

    @Test
    public void testCommitTransaction() {

    }

    @Test
    public void testRollbackTransaction() {

    }
}
