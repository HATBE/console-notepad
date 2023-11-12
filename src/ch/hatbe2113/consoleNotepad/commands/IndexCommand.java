package ch.hatbe2113.consoleNotepad.commands;

import ch.hatbe2113.consoleNotepad.Main;

public class IndexCommand extends Command {
    public IndexCommand(Main main) {
        super(main);
    }

    @Override
    public boolean onCommand(String[] args) {
        System.out.println("Index");
        return true;
    }
}
