package ch.hatbe2113.consoleNotepad.commands;

import ch.hatbe2113.consoleNotepad.Main;

public class ReplaceCommand extends Command {
    public ReplaceCommand(Main main) {
        super(main);
    }

    @Override
    public boolean onCommand(String[] args) {
        System.out.println("Replace");
        return true;
    }
}
