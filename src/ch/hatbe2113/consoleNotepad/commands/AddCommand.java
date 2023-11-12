package ch.hatbe2113.consoleNotepad.commands;

import ch.hatbe2113.consoleNotepad.Main;

public class AddCommand extends Command {
    public AddCommand(Main main) {
        super(main);
    }

    @Override
    public boolean onCommand(String[] args) {
        int line = 0; // TODO: add line at the bottom as default

        if(args.length > 0) {
            try {
               line = Integer.parseInt(args[0]);
            } catch(Exception e) {
                System.err.println("Please enter an int!");
                return false;
            }
        }

        System.out.println("Add at line: " + line);
        return true;
    }
}
