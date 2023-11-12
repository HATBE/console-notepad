package ch.hatbe2113.consoleNotepad.commands;

import ch.hatbe2113.consoleNotepad.Main;

public class DelCommand extends Command {
    public DelCommand(Main main) {
        super(main);
    }

    @Override
    public boolean onCommand(String[] args) {
        System.out.println("Del");
        return true;
    }
}
