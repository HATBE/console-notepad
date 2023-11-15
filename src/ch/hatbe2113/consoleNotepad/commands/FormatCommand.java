package ch.hatbe2113.consoleNotepad.commands;

import ch.hatbe2113.consoleNotepad.Main;
import ch.hatbe2113.consoleNotepad.notepad.Notepad;

public class FormatCommand extends Command {
    public FormatCommand(Main main) {
        super(main);
    }

    @Override
    public boolean onExecute(String[] args) {
        if(args.length >= 3 || args.length <= 0) {
            System.out.println(String.format("%sError! Too many or few arguments: use \"FORMAT (FIX [b] / RAW) \"!%s", Main.ANSI_RED, Main.ANSI_RESET));
            return false;
        }

        switch(args[0].toLowerCase()) {
            case "raw":
                if(args.length > 1) {
                    System.out.println(String.format("%sError! Too many arguments: use \"FORMAT RAW\"!%s", Main.ANSI_RED, Main.ANSI_RESET));
                    return false;
                }
                this.formatRaw();
                return true;
            case "fix":
                if(args.length < 2) {
                    System.out.println(String.format("%sError! Too few arguments: use \"FORMAT FIX <b>\"!%s", Main.ANSI_RED, Main.ANSI_RESET));
                    return false;
                }
                this.formatFix(args[1]);
                return true;
            default:
                System.out.println(String.format("%sError! wrong arguments: use \"FORMAT (FIX [b] / RAW)\"!%s", Main.ANSI_RED, Main.ANSI_RESET));
                return false;
        }
    }

    private void formatRaw() {
        this.main.getNotepad().setOutputMode(Notepad.OutPut.RAW);
    }

    private void formatFix(String columnWidth) {
        int columnWidthInt = -1;
        try {
            columnWidthInt = Integer.parseInt(columnWidth);
        } catch(Exception e) {
            System.out.println(String.format("%sError: Please enter a number as a second argument!%s", Main.ANSI_RED, Main.ANSI_RESET));
            return;
        }

        this.main.getNotepad().setOutputMode(Notepad.OutPut.FIX);
        this.main.getNotepad().setColumnWidth(columnWidthInt);
    }
}
