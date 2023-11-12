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
        this.commandHandler = new CommandHandler(this.main);
        this.registerCommands();
    }

    private void registerCommands() {
        this.commandHandler.register("add", new AddCommand());
        this.commandHandler.register("del", new DelCommand());
        this.commandHandler.register("dummy", new DummyCommand());
        this.commandHandler.register("exit", new ExitCommand());
        this.commandHandler.register("format", new FormatCommand());
        this.commandHandler.register("index", new IndexCommand());
        this.commandHandler.register("print", new PrintCommand());
        this.commandHandler.register("replace", new ReplaceCommand());
    }

    public void listen() {
        this.scanner = new Scanner(System.in);

        String userInput = scanner.nextLine();
        String[] userInputArray = userInput.split(" ");

        if(userInputArray.length < 1) {
            System.err.println("ERROR: Not a valid amount of arguments!");
        }

        String command = userInputArray[0];
        String[] args = null;

        if(userInputArray.length > 1) {
            args = userInputArray;
        }

        if(this.commandHandler.isCommand(command)) {
            this.commandHandler.executeCommand(command, args);
        } else {
            System.err.println(String.format("ERROR: \"%s\" Not a valid command!", command));
        }
    }
}
