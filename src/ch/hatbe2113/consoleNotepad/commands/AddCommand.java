package ch.hatbe2113.consoleNotepad.commands;

import ch.hatbe2113.consoleNotepad.Main;
import ch.hatbe2113.consoleNotepad.util.TextFormatter;

public class AddCommand extends Command {
    public AddCommand(Main main) {
        super(main);
    }

    @Override
    public boolean onExecute(String[] args) {
        int index = -1;
        String text = "";

        // return if too many arguments
        if(args.length >= 2) {
            System.out.printf("%sError! Too many arguments: use \"ADD [n]\"!%s\n", TextFormatter.ANSI_RED, TextFormatter.ANSI_RESET);
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

        text = this.main.getConsoleHandler().scan("Text:");
        text = TextFormatter.filterText(text);

        this.addParagraph(index, text);

        return true;
    }

    private boolean indexExists(int index) {
        return index <= 0 || index > this.main.getNotepad().getSize() + 1;
    }

    private void addParagraph(int index, String text) {
        if(index == -1) {
            // if index is -1, add paragraph at the end of the notepad
            this.main.getNotepad().addParagraph(text);
            return;
        }
        // else, add it at the specific index
        this.main.getNotepad().addParagraph(index - 1, text);
    }
}
