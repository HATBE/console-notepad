package ch.hatbe2113.consoleNotepad.commands;

import ch.hatbe2113.consoleNotepad.Main;
import ch.hatbe2113.consoleNotepad.io.ArgumentsHandler;
import ch.hatbe2113.consoleNotepad.util.TextFormatter;

public class DummyCommand extends Command {
    // random hard coded lorem ipsum dummy-text, can be changed if you feel funny
    String dummyText = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.";

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

        if(args.length > 0) {
            index = ArgumentsHandler.parseParagraphNumber("DUMMY", args , 0, main.getNotepad());
            if(index == -1) {
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
}
