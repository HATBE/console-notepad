package ch.hatbe2113.consoleNotepad.commands;

import ch.hatbe2113.consoleNotepad.Main;

public class DummyCommand extends Command {
    public DummyCommand(Main main) {
        super(main);
    }

    @Override
    public boolean onExecute(String[] args) {
        System.out.println("ADD is not implemented");
        return true;
    }
}
