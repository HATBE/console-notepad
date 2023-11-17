package ch.hatbe2113.consoleNotepad.commands;

import ch.hatbe2113.consoleNotepad.Main;
import ch.hatbe2113.consoleNotepad.util.TextFormatter;

public class IndexCommand extends Command {
    public IndexCommand(Main main) {
        super(main);
    }

    @Override
    public boolean onExecute(String[] args) {
        if(this.main.getNotepad().getSize() <= 0) {
            System.out.printf("%sError! Currently, the notepad is empty!%s\n", TextFormatter.ANSI_RED, TextFormatter.ANSI_RESET);
            return false;
        }

        boolean index = main.getNotepad().printIndex();

        // if index did not find anything to index, print error message
        if(!index) {
            System.out.printf("%sError! Currently, the notepad has nothing to index!%s\n", TextFormatter.ANSI_RED, TextFormatter.ANSI_RESET);
            return false;
        }

        return true;
    }
}
