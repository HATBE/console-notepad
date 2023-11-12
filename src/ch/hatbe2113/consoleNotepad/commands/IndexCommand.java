package ch.hatbe2113.consoleNotepad.commands;

public class IndexCommand extends Command {
    @Override
    public boolean onCommand(String[] args) {
        System.out.println("Index");
        return false;
    }
}
