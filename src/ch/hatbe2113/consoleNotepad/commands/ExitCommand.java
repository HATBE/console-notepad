package ch.hatbe2113.consoleNotepad.commands;

public class ExitCommand extends Command {
    @Override
    public boolean onCommand(String[] args) {
        System.out.println("Exit");
        return false;
    }
}
