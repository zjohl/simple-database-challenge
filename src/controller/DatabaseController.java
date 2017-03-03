package turo.codeexercise.controller;

import turo.codeexercise.command.*;
import turo.codeexercise.command.control.BeginCommand;
import turo.codeexercise.command.control.CommitCommand;
import turo.codeexercise.command.control.RollbackCommand;
import turo.codeexercise.command.data.*;
import turo.codeexercise.model.DatabaseModel;
import turo.codeexercise.model.IDatabaseModel;

import java.util.Stack;

/**
 * Database controller that manages trasactions and the execution of commands
 */
public class DatabaseController implements IDatabaseController {

    Stack<Stack<Command>> transactions;
    IDatabaseModel database;

    public DatabaseController(IDatabaseModel model) {
        this.transactions = new Stack<Stack<Command>>();
        this.database = model;
    }

    /**
     * Executes the given command and returns the appropriate output
     *
     * @param inputString a string containing a single database command
     * @return a string containing information requested by the user, or to indicate status
     */
    public String executeCommand(String inputString) {
        try {
            ICommand command = this.generateCommand(inputString);
            // if this is a data command and we're mid-transaction, add the command to the transaction
            if (command.isDataCommand() && this.hasActiveTransaction()) {
                Command rollback = command.createRollback(database);
                this.transactions.peek().push(rollback);
            }
            if (!command.isDataCommand()){
                return command.execute(this);
            } else {
                return command.execute(database);
            }
        } catch (IllegalArgumentException e){
            return "Received command was invalid";
        }
    }

    private ICommand generateCommand(String inputString) {
        if (inputString != null) {

            String[] commandArgs = inputString.split(" ");
            if (commandArgs[0] != null) {
                switch (commandArgs[0]) {
                    case "END":
                        return (ICommand) new EndCommand();
                    case "SET":
                        if (commandArgs.length == 3) {
                            return (ICommand) new SetCommand(commandArgs[1], commandArgs[2]);
                        }
                        throw new IllegalArgumentException("The provided command is not valid");
                    case "GET":
                        if (commandArgs.length == 2) {
                            return (ICommand) new GetCommand(commandArgs[1]);
                        }
                        throw new IllegalArgumentException("The provided command is not valid");
                    case "NUMEQUALTO":
                        if (commandArgs.length == 2) {
                            return (ICommand) new NumequaltoCommand(commandArgs[1]);
                        }
                        throw new IllegalArgumentException("The provided command is not valid");
                    case "UNSET":
                        if (commandArgs.length == 2) {
                            return (ICommand) new UnsetCommand(commandArgs[1]);
                        }
                        throw new IllegalArgumentException("The provided command is not valid");
                    case "BEGIN":
                        return (ICommand) new BeginCommand();
                    case "COMMIT":
                        return (ICommand) new CommitCommand();
                    case "ROLLBACK":
                        return (ICommand) new RollbackCommand();
                    default:
                        throw new IllegalArgumentException("The provided command is not valid");
                }
            }
        }
        throw new IllegalArgumentException("The provided command is not valid");
    }

    /**
     * Creates a new transaction block
     */
    public void createTransaction() {
        transactions.push(new Stack<Command>());
    }

    /**
     * Rolls back the changes made by the last transaction
     */
    public void rollbackTransaction() {
        if(this.hasActiveTransaction()) {
            while(transactions.peek().size() > 0) {
                transactions.peek().pop().execute(database);
            }
            transactions.pop();
        } else {
            throw new RuntimeException("No transactions to rollback");
        }

    }

    /**
     * Closes all open transations and applies their changes
     */
    public void commitTransaction() {
        if(this.hasActiveTransaction()) {
            this.transactions = new Stack<Stack<Command>>();
        } else {
            throw new RuntimeException("No transactions to commit");
        }
    }

    /**
     * Determines whether there is a currently active transaction
     *
     * @return true if there is an active transaction or transactions, false otherwise
     */
    private boolean hasActiveTransaction() {
        return transactions.size() > 0;
    }
}
