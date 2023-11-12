import io.ConsoleHandler;

import java.util.Scanner;

public class Main {

    private static ConsoleHandler consoleHandler;

    public static void main(String[] args) {
        Main.consoleHandler = new ConsoleHandler();

        System.out.println("Notepad");

        boolean run = true;

        while(run) {
            System.out.println("--------------------");
            consoleHandler.listen();
        }
    }
}