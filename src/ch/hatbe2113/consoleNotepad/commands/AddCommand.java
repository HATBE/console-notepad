package ch.hatbe2113.consoleNotepad.commands;

public class AddCommand extends Command {
    @Override
    public boolean onCommand(String[] args) {
        System.out.println("Add");
        return false;
    }
}
