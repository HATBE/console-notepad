package ch.hatbe2113.consoleNotepad.commands;

public class DummyCommand extends Command {
    @Override
    public boolean onCommand(String[] args) {
        System.out.println("ADD");
        return false;
    }
}
