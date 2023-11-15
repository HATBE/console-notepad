package ch.hatbe2113.consoleNotepad.commands;

import ch.hatbe2113.consoleNotepad.Main;
import ch.hatbe2113.consoleNotepad.util.TextFormatter;

public class DummyCommand extends Command {
    String dummyText = "Virtute praecedunt, quod fere cotidianis proeliis cum Germanis contendunt, septentr ionesimmensoslongusw ordos ionesimmensoslongusws.";

    public DummyCommand(Main main) {
        super(main);
    }

    @Override
    public boolean onExecute(String[] args) {
        int index = -1;

        if(args.length >= 2) {
            System.out.printf("%sError! Too many arguments: use \"DUMMY [n]\"!%s\n", TextFormatter.ANSI_RED, TextFormatter.ANSI_RESET);
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

        this.addParagraph(index, this.dummyText);

        return true;
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

    private boolean indexExists(int index) {
        return index <= 0 || index > this.main.getNotepad().getSize() + 1;
    }
}
