package ch.hatbe2113.consoleNotepad.commands;

import ch.hatbe2113.consoleNotepad.Main;

public class DelCommand extends Command {
    public DelCommand(Main main) {
        super(main);
    }

    @Override
    public boolean onExecute(String[] args) {
        int index = -1;

        // return if too many arguments
        if(args.length >= 2) {
            System.out.println(String.format("%sError! Too many arguments: use \"DEL [n]\"!%s", Main.ANSI_RED, Main.ANSI_RESET));
            return false;
        }

        if(args.length > 0) {
            try {
                index = Integer.parseInt(args[0]);
            } catch(Exception e) {
                System.out.println(String.format("%sError: Please enter a line number as a first argument!%s", Main.ANSI_RED, Main.ANSI_RESET));
                return false;
            }

            // notepad size, because you can just remove the line at the bottom
            if(this.indexExists(index)) {
                System.out.println(String.format("%sError! Line %s does not exist!%s", Main.ANSI_RED, index, Main.ANSI_RESET));
                return false;
            }
        }

        this.deleteParagraph(index);

        return true;
    }

    private boolean indexExists(int index) {
        return index <= 0 || index > main.getNotepad().getSize();
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
