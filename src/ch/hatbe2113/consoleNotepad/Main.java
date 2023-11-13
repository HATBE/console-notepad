package ch.hatbe2113.consoleNotepad;

import ch.hatbe2113.consoleNotepad.io.ConsoleHandler;
import ch.hatbe2113.consoleNotepad.notepad.NotepadHandler;

public class Main {

    private ConsoleHandler consoleHandler;
    private NotepadHandler notepadHandler;
    private boolean run = true;

    public Main() {
        this.consoleHandler = new ConsoleHandler(this);
        this.notepadHandler = new NotepadHandler(this);
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

    public void exit() {
        this.run = false;
    }

    public NotepadHandler getNotepadHandler() {
        return this.notepadHandler;
    }
}