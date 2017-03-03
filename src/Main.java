package turo.codeexercise;

import turo.codeexercise.controller.*;
import turo.codeexercise.model.*;
import turo.codeexercise.socket.IDatabaseSocket;
import turo.codeexercise.socket.StdInSocket;

public class Main {

    public static void main(String[] args) {
        IDatabaseSocket reader = new StdInSocket();

        IDatabaseModel model = new DatabaseModel();
        IDatabaseController controller = new DatabaseController(model);

        while(true) {
            String command = reader.getCommand();
            String output = controller.executeCommand(command);
            reader.displayOutput(output);
        }

    }
}
