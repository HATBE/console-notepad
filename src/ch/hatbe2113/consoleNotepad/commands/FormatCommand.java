package ch.hatbe2113.consoleNotepad.commands;

public class FormatCommand extends Command {
    @Override
    public boolean onCommand(String[] args) {
        System.out.println("Format");
        return false;
    }
}
