package commands;

public class DelCommand extends Command {
    @Override
    public boolean onCommand() {
        System.out.println("Del");
        return false;
    }
}
