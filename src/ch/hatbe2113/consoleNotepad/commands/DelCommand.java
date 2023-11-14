package ch.hatbe2113.consoleNotepad.commands;

import ch.hatbe2113.consoleNotepad.Main;

public class DelCommand extends Command {
    public DelCommand(Main main) {
        super(main);
    }

    @Override
    public boolean onExecute(String[] args) {
        int index = -1;

        if(args.length > 0) {
            try {
                index = Integer.parseInt(args[0]);
            } catch(Exception e) {
                System.out.println(String.format("%sError: Please enter an int!%s", Main.ANSI_RED, Main.ANSI_RESET));
                return false;
            }

            // notepad size, because you can just remove the line at the bottom
            if(index <= 0 || index > main.getNotepadHandler().getSize()) {
                System.out.println(String.format("%sError! Line %s does not exist!%s", Main.ANSI_RED, index, Main.ANSI_RESET));
                return false;
            }
        }

        System.out.println(String.format("Line at index %s removed", index));

        if(index == -1) {
            // if index is -1, remove paragraph at the end of the notepad
            main.getNotepadHandler().removeParagraph();
        } else {
            // else, remove it at the specific index
            main.getNotepadHandler().removeParagraph(index - 1);
        }

        return true;
    }
}
