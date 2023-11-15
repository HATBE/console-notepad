package ch.hatbe2113.consoleNotepad.util;

public class TextFormatter {
    public static final String ANSI_WHITE = "\u001B[37m", ANSI_GREEN = "\u001B[32m", ANSI_RED = "\u001B[31m", ANSI_RESET = "\u001B[0m";

    public static String lineBreak(String text, int columnWidth) {
        StringBuilder output = new StringBuilder();
        int currentLineLength = 0;

        String[] words = text.split(" ");

        for(String word : words) {
            if(currentLineLength > 0) {
                // if not first line, append space
                output.append(" ");
                currentLineLength++;
            }

            if(currentLineLength + word.length() > columnWidth) {
                output.append("\n");
                currentLineLength = 0; // reset to the beginning of the line

                // if the word is longer than the column width, break it
                while(word.length() > columnWidth) {
                    output.append(word, 0, columnWidth);
                    output.append("\n");
                    word = word.substring(columnWidth);
                }
            }

            output.append(word);
            currentLineLength += word.length();
        }

        return output.toString();
    }

    public static String filterText(String text) {
        // filter the text. Allowed: (a-z, A-Z, äöüÄÖÜ, 0-9, .,:;-!? '()"%@+*[]{}/\&#$),
        return text.replaceAll("[^a-zA-ZäöüÄÖÜ0-9.,:;!? '()\"%@+*\\[\\]{}\\/\\\\&#$-]", "");
    }
}
