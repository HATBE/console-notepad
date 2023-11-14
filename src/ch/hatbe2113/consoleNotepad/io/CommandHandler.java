package ch.hatbe2113.consoleNotepad.io;

import ch.hatbe2113.consoleNotepad.Main;
import ch.hatbe2113.consoleNotepad.commands.Command;

import java.util.HashMap;

public class CommandHandler {
    private final Main main;
    private HashMap<String, Command> commands = new HashMap<String, Command>();

    public CommandHandler(Main main) {
        this.main = main;
    }

    public void registerCommand(String name, Command command) {
        if(this.isCommand(name)) {
            return;
        }
        this.commands.put(name, command);
    }

    public void executeCommand(String name, String[] args) {
        if(!this.isCommand(name)) {
            return;
        }
        this.commands.get(name).onExecute(args);
    }

    public HashMap<String, Command> getCommands() {
        return this.commands;
    }

    public boolean isCommand(String name) {
        return this.commands.containsKey(name);
    }
}
