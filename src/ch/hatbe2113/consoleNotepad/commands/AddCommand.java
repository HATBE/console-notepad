package ch.hatbe2113.consoleNotepad.commands;

import ch.hatbe2113.consoleNotepad.Main;
import ch.hatbe2113.consoleNotepad.notepad.NotepadHandler;

public class AddCommand extends Command {


    public AddCommand(Main main) {
        super(main);
    }

    @Override
    public boolean onCommand(String[] args) {
        int index = main.getNotepadHandler().getNotepadSize();

        if(args.length > 0) {
            try {
               index = Integer.parseInt(args[0]);
            } catch(Exception e) {
                System.err.println("Please enter an int!");
                return false;
            }
        }

        System.out.println("Add at line: " + index);

        main.getNotepadHandler().addParagraph(index, "TEST");

        return true;
    }
}
