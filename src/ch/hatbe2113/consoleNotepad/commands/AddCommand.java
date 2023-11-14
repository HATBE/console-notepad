package ch.hatbe2113.consoleNotepad.commands;

import ch.hatbe2113.consoleNotepad.Main;

public class AddCommand extends Command {

    public AddCommand(Main main) {
        super(main);
    }

    @Override
    public boolean onExecute(String[] args) {
        // set index to bottom of file as standard
        int index = -1;
        String text = "";

        // parse second argument to index (int)
        if(args.length > 0) {
            try {
               index = Integer.parseInt(args[0]);
            } catch(Exception e) {
                System.out.println(String.format("%sError: Please enter a line number as a first argument!%s", Main.ANSI_RED, Main.ANSI_RESET));
                return false;
            }

            // notepad size + 1, because you can add a line at the bottom, which is notepad size + 1
            if(index <= 0 || index > main.getNotepadHandler().getSize() + 1)  {
                System.out.println(String.format("%sError! Line %s does not exist!%s", Main.ANSI_RED, index, Main.ANSI_RESET));
                return false;
            }
        }

        text = main.getConsoleHandler().scan("Text:");

        if(index == -1) {
            // if index is -1, add paragraph at the end of the notepad
            main.getNotepadHandler().addParagraph(text);
        } else {
            // else, add it at the specific index
            main.getNotepadHandler().addParagraph(index - 1, text);
        }

        return true;
    }
}
