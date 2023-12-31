package ch.hatbe2113.consoleNotepad.commands;

import ch.hatbe2113.consoleNotepad.Main;

public class ExitCommand extends Command {
    public ExitCommand(Main main) {
        super(main);
    }

    @Override
    public boolean onExecute(String[] args) {
        System.out.println("Exiting Notepad...");
        this.main.exitProgram();
        return true;
    }
}
