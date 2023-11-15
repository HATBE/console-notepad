package ch.hatbe2113.consoleNotepad.commands;

import ch.hatbe2113.consoleNotepad.Main;
import ch.hatbe2113.consoleNotepad.notepad.Notepad;
import ch.hatbe2113.consoleNotepad.util.TextFormatter;

public class FormatCommand extends Command {
    public FormatCommand(Main main) {
        super(main);
    }

    @Override
    public boolean onExecute(String[] args) {
        if(args.length >= 3 || args.length <= 0) {
            System.out.printf("%sError! Too many or few arguments: use \"FORMAT (FIX [b] / RAW) \"!%s\n", TextFormatter.ANSI_RED, TextFormatter.ANSI_RESET);
            return false;
        }

        switch(args[0].toLowerCase()) {
            case "raw":
                if(args.length > 1) {
                    System.out.printf("%sError! Too many arguments: use \"FORMAT RAW\"!%s\n", TextFormatter.ANSI_RED, TextFormatter.ANSI_RESET);
                    return false;
                }
                this.formatRaw();
                return true;
            case "fix":
                if(args.length < 2) {
                    System.out.printf("%sError! Too few arguments: use \"FORMAT FIX <b>\"!%s\n", TextFormatter.ANSI_RED, TextFormatter.ANSI_RESET);
                    return false;
                }
                this.formatFix(args[1]);
                return true;
            default:
                System.out.printf("%sError! wrong arguments: use \"FORMAT (FIX [b] / RAW)\"!%s\n", TextFormatter.ANSI_RED, TextFormatter.ANSI_RESET);
                return false;
        }
    }

    private void formatRaw() {
        this.main.getNotepad().setOutputMode(Notepad.Output.RAW);
    }

    private void formatFix(String columnWidth) {
        int columnWidthInt = -1;
        try {
            columnWidthInt = Integer.parseInt(columnWidth);
        } catch(Exception e) {
            System.out.printf("%sError: Please enter a number as a second argument!%s\n", TextFormatter.ANSI_RED, TextFormatter.ANSI_RESET);
            return;
        }

        this.main.getNotepad().setOutputMode(Notepad.Output.FIX);
        this.main.getNotepad().setColumnWidth(columnWidthInt);
    }
}
