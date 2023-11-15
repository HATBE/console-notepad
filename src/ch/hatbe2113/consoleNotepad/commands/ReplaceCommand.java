package ch.hatbe2113.consoleNotepad.commands;

import ch.hatbe2113.consoleNotepad.Main;
import ch.hatbe2113.consoleNotepad.util.TextFormatter;

public class ReplaceCommand extends Command {
    public ReplaceCommand(Main main) {
        super(main);
    }

    @Override
    public boolean onExecute(String[] args) {
        int index = -1;
        String toReplace = "";
        String replaceTo = ""
;
        // return if too many arguments
        if(args.length >= 2) {
            System.out.printf("%sError! Too many arguments: use \"REPLACE [n]\"!%s\n", TextFormatter.ANSI_RED, TextFormatter.ANSI_RESET);
            return false;
        }

        // parse second argument to index (int)
        if(args.length > 0) {
            try {
                index = Integer.parseInt(args[0]);
            } catch(Exception e) {
                System.out.printf("%sError: Please enter a line number as a first argument!%s\n", TextFormatter.ANSI_RED, TextFormatter.ANSI_RESET);
                return false;
            }

            // notepad size + 1, because you can add a line at the bottom, which is notepad size + 1
            if(this.indexExists(index))  {
                System.out.printf("%sError! Line %s does not exist!%s\n", TextFormatter.ANSI_RED, index, TextFormatter.ANSI_RESET);
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

    private boolean indexExists(int index) {
        return index <= 0 || index > this.main.getNotepad().getSize() + 1;
    }
}
