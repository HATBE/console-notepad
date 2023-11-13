package ch.hatbe2113.consoleNotepad.commands;

import ch.hatbe2113.consoleNotepad.Main;

public abstract class Command {
    protected Main main;

    public Command(Main main) {
        this.main = main;
    }

    public abstract boolean onExecute(String[] args);
}
