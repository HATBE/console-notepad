package ch.hatbe2113.consoleNotepad;

import ch.hatbe2113.consoleNotepad.commands.*;
import ch.hatbe2113.consoleNotepad.io.CommandHandler;
import ch.hatbe2113.consoleNotepad.io.ConsoleHandler;
import ch.hatbe2113.consoleNotepad.io.NotepadHandler;
import ch.hatbe2113.consoleNotepad.notepad.Notepad;
import ch.hatbe2113.consoleNotepad.util.TextFormatter;

public class Main {
    private final Notepad notepad;
    private final ConsoleHandler consoleHandler;
    private final CommandHandler commandHandler;
    private final NotepadHandler notepadHandler;

    private boolean run = true;

    public Main() {
        this.notepad = new Notepad();
        this.consoleHandler = new ConsoleHandler(this);
        this.commandHandler = new CommandHandler(this);
        this.notepadHandler = new NotepadHandler(this);
    }

    public static void main(String[] args) {
        Main mainInstance = new Main();

        mainInstance.registerCommands();

        mainInstance.loop();

        System.exit(0);
    }

    private void loop() {
        System.out.printf("Console Notepad %sby Genny%s\n", TextFormatter.ANSI_GREEN, TextFormatter.ANSI_RESET);
        System.out.println("--------------------");

        while(this.run) {
           this.notepadHandler.scanCommands();
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

    public Notepad getNotepad() {
        return this.notepad;
    }

    public CommandHandler getCommandHandler() {
        return this.commandHandler;
    }

    public ConsoleHandler getConsoleHandler() {
        return consoleHandler;
    }
}