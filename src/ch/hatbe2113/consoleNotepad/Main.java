package ch.hatbe2113.consoleNotepad;

import ch.hatbe2113.consoleNotepad.io.ConsoleHandler;

public class Main {

    private ConsoleHandler consoleHandler;
    private boolean run = true;

    public Main() {
        this.consoleHandler = new ConsoleHandler(this);
    }

    public static void main(String[] args) {
        Main mainInstance = new Main();

        System.out.println("Notepad");

        boolean run = true;

        while(mainInstance.run) {
            System.out.println("--------------------");
            System.out.print("Command: ");
            mainInstance.consoleHandler.listen();
        }
    }

    public void stop() {
        this.run = false;
    }
}