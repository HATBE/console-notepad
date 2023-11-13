package ch.hatbe2113.consoleNotepad.commands;

import ch.hatbe2113.consoleNotepad.Main;

import java.util.HashMap;

public class CommandHandler {
    private Main main;
    private HashMap<String, Command> commands = new HashMap<String, Command>();

    public CommandHandler(Main main) {
        this.main = main;
    }

    public void register(String name, Command command) {
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
