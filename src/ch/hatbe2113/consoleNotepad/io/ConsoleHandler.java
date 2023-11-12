package ch.hatbe2113.consoleNotepad.io;

import ch.hatbe2113.consoleNotepad.Main;
import ch.hatbe2113.consoleNotepad.commands.*;

import java.util.Scanner;

public class ConsoleHandler {

    private Main main;
    private Scanner scanner;
    private CommandHandler commandHandler;

    public ConsoleHandler(Main main) {
        this.main = main;
        this.scanner = new Scanner(System.in);
        this.commandHandler = new CommandHandler(this.main);
        this.registerCommands();
    }

    private void registerCommands() {
        this.commandHandler.register("add", new AddCommand(this.main));
        this.commandHandler.register("del", new DelCommand(this.main));
        this.commandHandler.register("dummy", new DummyCommand(this.main));
        this.commandHandler.register("exit", new ExitCommand(this.main));
        this.commandHandler.register("format", new FormatCommand(this.main));
        this.commandHandler.register("index", new IndexCommand(this.main));
        this.commandHandler.register("print", new PrintCommand(this.main));
        this.commandHandler.register("replace", new ReplaceCommand(this.main));
    }

    public void listen() {
        String userInput = scanner.nextLine();
        String[] userInputArray = userInput.split(" ");

        if(userInputArray.length < 1) {
            System.err.println("ERROR: Not a valid amount of arguments!");
        }

        String command = userInputArray[0];
        String[] args = {};

        if(userInputArray.length > 1) {
            // array shift
            for(int i = userInputArray.length - 1; i > 0; i--) {
                userInputArray[i-1] = userInputArray[i];
            }

            args = userInputArray;
        }

        if(this.commandHandler.isCommand(command.toLowerCase())) {
            this.commandHandler.executeCommand(command.toLowerCase(), args);
        } else {
            System.err.println(String.format("ERROR: \"%s\" Not a valid command!", command));
        }
    }
}
