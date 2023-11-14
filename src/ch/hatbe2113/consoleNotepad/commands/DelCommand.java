package ch.hatbe2113.consoleNotepad.commands;

import ch.hatbe2113.consoleNotepad.Main;

public class DelCommand extends Command {
    public DelCommand(Main main) {
        super(main);
    }

    @Override
    public boolean onExecute(String[] args) {
        int index = 0;

        if(args.length > 0) {
            try {
                index = Integer.parseInt(args[0]) - 1;
            } catch(Exception e) {
                System.err.println("Please enter an int!");
                return false;
            }
        }

        if(index > main.getNotepadHandler().getSize() || index < 1) {
            System.err.printf("Line %s does not exist yet!\n", index + 1);
            return false;
        }

        System.out.printf("Line at index %s removed\n", index + 1);

        main.getNotepadHandler().removeParagraph(index);

        return true;
    }
}
