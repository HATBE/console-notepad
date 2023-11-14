package ch.hatbe2113.consoleNotepad;

import ch.hatbe2113.consoleNotepad.commands.*;
import ch.hatbe2113.consoleNotepad.io.CommandHandler;
import ch.hatbe2113.consoleNotepad.io.ConsoleHandler;
import ch.hatbe2113.consoleNotepad.io.NotepadHandler;
import ch.hatbe2113.consoleNotepad.notepad.Notepad;

public class Main {

    private final ConsoleHandler consoleHandler;
    private final Notepad notePad;
    private final CommandHandler commandHandler;
    private final NotepadHandler notepadHandler;

    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    private boolean run = true;

    public Main() {
        this.consoleHandler = new ConsoleHandler(this);
        this.commandHandler = new CommandHandler(this);
        this.notepadHandler = new NotepadHandler(this);
        this.notePad = new Notepad(this);
    }

    public static void main(String[] args) {
        Main mainInstance = new Main();

        mainInstance.registerCommands();

        mainInstance.loop();
    }

    private void loop() {
        System.out.println("Console Notepad");
        System.out.println("--------------------");

        while(this.run) {
           this.notepadHandler.scanCommands();
        }

        System.exit(0);
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

    public Notepad getNotepad() {
        return this.notePad;
    }

    public CommandHandler getCommandHandler() {
        return this.commandHandler;
    }

    public ConsoleHandler getConsoleHandler() {
        return consoleHandler;
    }
}