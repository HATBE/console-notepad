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

    // Scanner with text
    public String scan(String text) {
        System.out.printf("%s: ", text);
        return this.scan();
    }

    public String scan() {
        return this.scanner.nextLine();
    }
}
