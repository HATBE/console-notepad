package ch.hatbe2113.consoleNotepad;

import ch.hatbe2113.consoleNotepad.commands.*;
import ch.hatbe2113.consoleNotepad.io.CommandHandler;
import ch.hatbe2113.consoleNotepad.io.ConsoleHandler;
import ch.hatbe2113.consoleNotepad.notepad.NotePad;

public class Main {

    private final ConsoleHandler consoleHandler;
    private final NotePad notepadHandler;
    private final CommandHandler commandHandler;

    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";


    private boolean run = true;

    public Main() {
        this.consoleHandler = new ConsoleHandler(this);
        this.notepadHandler = new NotePad(this);
        this.commandHandler = new CommandHandler(this);
    }

    public static void main(String[] args) {
        Main mainInstance = new Main();

        mainInstance.registerCommands();

        mainInstance.loop();
    }

    private void loop() {
        System.out.println("Notepad");
        System.out.println("--------------------");

        while(this.run) {
            String userInput = this.getConsoleHandler().scan(">");

            String[] userInputArray = userInput.split(" ");

            if(userInputArray.length < 1) {
                System.out.println(String.format("%sERROR: Not a valid amount of arguments!%s", Main.ANSI_RED, Main.ANSI_RESET));
            }

            String command = userInputArray[0].toLowerCase();
            String[] arguments = new String[Math.max(userInputArray.length - 1, 0)];

            if(userInputArray.length > 1) {
                // array copy -> into arguments
                System.arraycopy(userInputArray, 1, arguments, 0, userInputArray.length - 1);
            }

            if(!this.getCommandHandler().isCommand(command)) {
                System.out.println(String.format("%sERROR: \"%s\" Not a valid command!%s", Main.ANSI_RED, command, Main.ANSI_RESET));
            } else {
                this.getCommandHandler().executeCommand(command, arguments);
            }
        }
    }

    private void registerCommands() {
        this.commandHandler.registerCommand("add", new AddCommand(this));
        this.commandHandler.registerCommand("del", new DelCommand(this));
        this.commandHandler.registerCommand("dummy", new DummyCommand(this));
        this.commandHandler.registerCommand("exit", new ExitCommand(this));
        this.commandHandler.registerCommand("format", new FormatCommand(this));
        this.commandHandler.registerCommand("index", new IndexCommand(this));
        this.commandHandler.registerCommand("print", new PrintCommand(this));
        this.commandHandler.registerCommand("replace", new ReplaceCommand(this));
    }

    public void exitProgram() {
        this.run = false;
    }

    public NotePad getNotepadHandler() {
        return this.notepadHandler;
    }

    public CommandHandler getCommandHandler() {
        return this.commandHandler;
    }

    public ConsoleHandler getConsoleHandler() {
        return consoleHandler;
    }
}