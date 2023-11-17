package ch.hatbe2113.consoleNotepad.io;

import ch.hatbe2113.consoleNotepad.notepad.Notepad;
import ch.hatbe2113.consoleNotepad.util.TextFormatter;

public class ArgumentsHandler {
    public static int parseParagraphNumber(String commandName, String[] args, int idx, Notepad notepad) {
        int index = -1;

        // parse "idx'th" argument to index (int)
        try {
            index = Integer.parseInt(args[idx]);
        } catch(Exception e) {
            System.out.printf("%sError: Please enter a line number as a %s. argument!%s\n", TextFormatter.ANSI_RED, idx + 1, TextFormatter.ANSI_RESET);
            return -1;
        }

        // notepad size + 1, because you can add a line at the bottom, which is notepad size + 1
        if(notepad.indexExists(index))  {
            System.out.printf("%sError! Line %s does not exist!%s\n", TextFormatter.ANSI_RED, index, TextFormatter.ANSI_RESET);
            return -1;
        }

        return index;
    }
}
