package ch.hatbe2113.consoleNotepad.commands;

public class DelCommand extends Command {
    @Override
    public boolean onCommand(String[] args) {
        System.out.println("Del");
        return false;
    }
}
