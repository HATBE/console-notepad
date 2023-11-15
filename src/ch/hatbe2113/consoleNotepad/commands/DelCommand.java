package ch.hatbe2113.consoleNotepad.commands;

import ch.hatbe2113.consoleNotepad.Main;
import ch.hatbe2113.consoleNotepad.io.ArgumentsHandler;
import ch.hatbe2113.consoleNotepad.util.TextFormatter;

public class DelCommand extends Command {
    public DelCommand(Main main) {
        super(main);
    }

    @Override
    public boolean onExecute(String[] args) {
        int index = -1;

        // return if too many arguments
        if(args.length >= 2) {
            System.out.printf("%sError! Too many arguments: use \"DEL [n]\"!%s\n", TextFormatter.ANSI_RED, TextFormatter.ANSI_RESET);
            return false;
        }

        if(args.length > 0) {
            index = ArgumentsHandler.parseParagraphNumber("DEL", args , 0, main.getNotepad());
            if(index == -1) {
                return false;
            }
        }

        this.deleteParagraph(index);

        return true;
    }

    private void deleteParagraph(int index) {
        if(index == -1) {
            // if index is -1, remove paragraph at the end of the notepad
            main.getNotepad().removeParagraph();
        } else {
            // else, remove it at the specific index
            main.getNotepad().removeParagraph(index - 1);
        }
    }
}
