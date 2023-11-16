package ch.hatbe2113.consoleNotepad.commands;

import ch.hatbe2113.consoleNotepad.Main;
import ch.hatbe2113.consoleNotepad.util.TextFormatter;

public class PrintCommand extends Command {
    public PrintCommand(Main main) {
        super(main);
    }

    @Override
    public boolean onExecute(String[] args) {
        if(this.main.getNotepad().getSize() <= 0) {
            System.out.printf("%sError! Currently, the notepad is empty!%s\n", TextFormatter.ANSI_RED, TextFormatter.ANSI_RESET);
            return false;
        }

        main.getNotepad().print();

        return true;
    }
}
