package ch.hatbe2113.consoleNotepad.commands;

import ch.hatbe2113.consoleNotepad.Main;
import ch.hatbe2113.consoleNotepad.notepad.NotepadHandler;

public class PrintCommand extends Command {


    public PrintCommand(Main main) {
        super(main);
    }

    @Override
    public boolean onExecute(String[] args) {
        main.getNotepadHandler().print();
        return true;
    }
}
