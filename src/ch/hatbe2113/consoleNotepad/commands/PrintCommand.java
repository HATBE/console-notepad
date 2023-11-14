package ch.hatbe2113.consoleNotepad.commands;

import ch.hatbe2113.consoleNotepad.Main;

public class PrintCommand extends Command {


    public PrintCommand(Main main) {
        super(main);
    }

    @Override
    public boolean onExecute(String[] args) {
        if(this.main.getNotepad().getSize() <= 0) {
            System.out.println(String.format("%sError! Currently, the notepad is empty!%s", Main.ANSI_RED, Main.ANSI_RESET));
            return false;
        }

        main.getNotepad().print();
        return true;
    }
}
