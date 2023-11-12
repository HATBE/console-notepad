package commands;

public class PrintCommand extends Command {
    @Override
    public boolean onCommand() {
        System.out.println("Print");
        return false;
    }
}
