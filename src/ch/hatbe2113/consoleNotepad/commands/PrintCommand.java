package ch.hatbe2113.consoleNotepad.commands;

public class PrintCommand extends Command {
    @Override
    public boolean onCommand(String[] args) {
        System.out.println("Print");
        return false;
    }
}
