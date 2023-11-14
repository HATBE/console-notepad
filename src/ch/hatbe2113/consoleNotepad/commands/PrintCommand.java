package ch.hatbe2113.consoleNotepad.commands;

import ch.hatbe2113.consoleNotepad.Main;

public class PrintCommand extends Command {


    public PrintCommand(Main main) {
        super(main);
    }

    @Override
    public boolean onExecute(String[] args) {
        main.getNotepad().print();
        return true;
    }
}
