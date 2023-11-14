package ch.hatbe2113.consoleNotepad.io;

import ch.hatbe2113.consoleNotepad.Main;

public class NotepadHandler {

    private final Main main;
    public NotepadHandler(Main main) {
        this.main = main;
    }

    public void scanCommands() {
        String userInput = this.main.getConsoleHandler().scan(">");

        String[] userInputArray = userInput.split(" ");

        if(userInputArray.length < 1) {
            System.out.println(String.format("%sERROR: Not a valid amount of arguments!%s", Main.ANSI_RED, Main.ANSI_RESET));
        }

        String command = userInputArray[0].toLowerCase();
        String[] args = new String[Math.max(userInputArray.length - 1, 0)];

        if(userInputArray.length > 1) {
            // array copy -> into arguments
            System.arraycopy(userInputArray, 1, args, 0, userInputArray.length - 1);
        }

        this.executeCommand(command, args);
    }

    private void executeCommand(String command, String[] args) {
        if(!this.main.getCommandHandler().isCommand(command)) {
            System.out.println(String.format("%sERROR: \"%s\" Not a valid command!%s", Main.ANSI_RED, command, Main.ANSI_RESET));
        } else {
            this.main.getCommandHandler().executeCommand(command, args);
        }
    }


}
