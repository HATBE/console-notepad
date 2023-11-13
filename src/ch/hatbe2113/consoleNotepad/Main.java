package ch.hatbe2113.consoleNotepad;

import ch.hatbe2113.consoleNotepad.commands.*;
import ch.hatbe2113.consoleNotepad.io.ConsoleHandler;
import ch.hatbe2113.consoleNotepad.notepad.NotepadHandler;

public class Main {

    private final ConsoleHandler consoleHandler;
    private final NotepadHandler notepadHandler;
    private final CommandHandler commandHandler;

    private boolean run = true;

    public Main() {
        this.consoleHandler = new ConsoleHandler(this);
        this.notepadHandler = new NotepadHandler(this);
        this.commandHandler = new CommandHandler(this);
    }

    public static void main(String[] args) {
        Main mainInstance = new Main();

        mainInstance.registerCommands();

        System.out.println("Notepad");

        boolean run = true;

        while(mainInstance.run) {
            System.out.println("--------------------");
            String userInput = mainInstance.consoleHandler.scan("Command");

            String[] userInputArray = userInput.split(" ");

            if(userInputArray.length < 1) {
                System.err.println("ERROR: Not a valid amount of arguments!");
            }

            String command = userInputArray[0].toLowerCase();
            String[] arguments = new String[Math.max(userInputArray.length - 1, 0)];

            if(userInputArray.length > 1) {
                // array copy -> into arguments
                System.arraycopy(userInputArray, 1, arguments, 0, userInputArray.length - 1);
            }

            if(!mainInstance.getCommandHandler().isCommand(command)) {
                System.err.printf("ERROR: \"%s\" Not a valid command!\n", command);
                return;
            }

            mainInstance.getCommandHandler().executeCommand(command, arguments);
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

    public void exit() {
        this.run = false;
    }

    public NotepadHandler getNotepadHandler() {
        return this.notepadHandler;
    }

    public CommandHandler getCommandHandler() {
        return this.commandHandler;
    }
}