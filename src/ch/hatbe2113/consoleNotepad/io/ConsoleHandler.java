package ch.hatbe2113.consoleNotepad.io;

import ch.hatbe2113.consoleNotepad.Main;

import java.util.Scanner;

public class ConsoleHandler {

    private final Main main;
    private final Scanner scanner;

    public ConsoleHandler(Main main) {
        this.main = main;
        this.scanner = new Scanner(System.in);
    }


    public void scan(String text) {
        System.out.printf("%s: ", text);
        this.scan();
    }

    public void scan() {
        String userInput = scanner.nextLine();
        String[] userInputArray = userInput.split(" ");

        if(userInputArray.length < 1) {
            System.err.println("ERROR: Not a valid amount of arguments!");
        }

        String command = userInputArray[0].toLowerCase();
        String[] args = new String[userInputArray.length - 1];

        if(userInputArray.length > 1) {
            // array copy -> into args
            System.arraycopy(userInputArray, 1, args, 0, userInputArray.length - 1);
        }

        if(!main.getCommandHandler().isCommand(command)) {
            System.err.printf("ERROR: \"%s\" Not a valid command!%n", command);
            return;
        }

        main.getCommandHandler().executeCommand(command, args);
    }
}
