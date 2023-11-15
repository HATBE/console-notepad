package ch.hatbe2113.consoleNotepad.commands;

import ch.hatbe2113.consoleNotepad.Main;
import ch.hatbe2113.consoleNotepad.io.ArgumentsHandler;
import ch.hatbe2113.consoleNotepad.util.TextFormatter;

public class ReplaceCommand extends Command {
    public ReplaceCommand(Main main) {
        super(main);
    }

    @Override
    public boolean onExecute(String[] args) {
        int index = -1;
        String toReplace = "";
        String replaceTo = "";

        // return if too many arguments
        if(args.length >= 2) {
            System.out.printf("%sError! Too many arguments: use \"REPLACE [n]\"!%s\n", TextFormatter.ANSI_RED, TextFormatter.ANSI_RESET);
            return false;
        }

        if(args.length > 0) {
            index = ArgumentsHandler.parseParagraphNumber("REPLACE", args , 0, main.getNotepad());
            if(index == -1) {
                return false;
            }
        }

        toReplace = this.main.getConsoleHandler().scan("Word to find:");
        toReplace = TextFormatter.filterText(toReplace);

        replaceTo = this.main.getConsoleHandler().scan("Replace with:");
        replaceTo = TextFormatter.filterText(replaceTo);

        this.replaceWord(index, toReplace, replaceTo);

        return true;
    }

    private void replaceWord(int index, String toReplace, String replaceTo) {
        if(index == -1) {
            // if index is -1, replace in paragraph at the end of the notepad
            this.main.getNotepad().replaceWord(toReplace, replaceTo);
            return;
        }
        // else, replace in the specific index
        this.main.getNotepad().replaceWord(index - 1, toReplace, replaceTo);
    }
}
