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
            mainInstance.consoleHandler.scan("Command");
        }
    }

    private void registerCommands() {
        this.commandHandler.register("add", new AddCommand(this));
        this.commandHandler.register("del", new DelCommand(this));
        this.commandHandler.register("dummy", new DummyCommand(this));
        this.commandHandler.register("exit", new ExitCommand(this));
        this.commandHandler.register("format", new FormatCommand(this));
        this.commandHandler.register("index", new IndexCommand(this));
        this.commandHandler.register("print", new PrintCommand(this));
        this.commandHandler.register("replace", new ReplaceCommand(this));
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