package commands;

public class ExitCommand extends Command {
    @Override
    public boolean onCommand() {
        System.out.println("Exit");
        return false;
    }
}
