package io;

import commands.*;

import java.util.Scanner;

public class ConsoleHandler {

    private Scanner scanner;
    private CommandHandler commandHandler;

    public ConsoleHandler() {
        this.scanner = new Scanner(System.in);
        this.commandHandler = new CommandHandler();
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
        String userInput = scanner.nextLine();
        String[] userInputArray = userInput.split(" ");

        if(userInputArray.length < 1) {
            System.err.println("ERROR: not a valid amount of arguments!");
        }

        switch(userInputArray[0].toUpperCase()) {
            default:
                System.err.println("ERROR: wrong argument");
                break;
        }
    }
}
