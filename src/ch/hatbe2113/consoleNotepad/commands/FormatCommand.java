package ch.hatbe2113.consoleNotepad.commands;

import ch.hatbe2113.consoleNotepad.Main;

public class FormatCommand extends Command {
    public FormatCommand(Main main) {
        super(main);
    }

    @Override
    public boolean onExecute(String[] args) {
        System.out.println("FORMAT is not implemented");
        return true;
    }
}
