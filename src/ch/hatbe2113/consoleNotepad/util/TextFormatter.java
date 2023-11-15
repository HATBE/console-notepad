package ch.hatbe2113.consoleNotepad.util;

public class TextFormatter {
    public static String lineBreak(String text, int columnWidth) {
        StringBuilder output = new StringBuilder();
        int currentLineLength = 0;

        String[] words = text.split(" ");
        for (String word : words) {
            if (currentLineLength + word.length() + 1 <= columnWidth) {
                if (currentLineLength > 0) {
                    output.append(" ");
                    currentLineLength++;
                }
                output.append(word);
                currentLineLength += word.length();
            } else {
                output.append("\n");
                currentLineLength = 0; // reset to the beginning of the line
                // if the word is longer that the column width, break it
                while (word.length() > columnWidth) {
                    output.append(word, 0, columnWidth);
                    output.append("\n");
                    word = word.substring(columnWidth);
                }
                output.append(word);
                currentLineLength += word.length();
            }
        }

        return output.toString();
    }
}
