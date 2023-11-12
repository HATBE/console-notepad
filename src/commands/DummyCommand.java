package commands;

public class DummyCommand extends Command {
    @Override
    public boolean onCommand() {
        System.out.println("ADD");
        return false;
    }
}
