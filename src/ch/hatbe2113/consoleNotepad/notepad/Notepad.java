package ch.hatbe2113.consoleNotepad.notepad;

import ch.hatbe2113.consoleNotepad.util.TextFormatter;

import java.util.ArrayList;
import java.util.List;

public class Notepad {
    public enum OutputModes {
        RAW,
        FIX
    }

    private final List<String> paragraphs = new ArrayList<>();
    private int columnWidth = 0;
    private OutputModes outputMode = OutputModes.RAW;

    // add paragraph at certain index
    public void addParagraph(int index, String text) {
        this.paragraphs.add(index, text);
    }

    // add paragraph at the end
    public void addParagraph(String text) {
        this.paragraphs.add(text);
    }

    // delete paragraph at certain index
    public void removeParagraph(int index) {
        this.paragraphs.remove(index);
    }

    // delete paragraph at the end
    public void removeParagraph() {
        this.removeParagraph(this.getSize() - 1);
    }

    public int getSize() {
        return this.paragraphs.size();
    }

    public void print() {
        // if notepad is empty, return
        if(this.getSize() <= 0) {
            return;
        }

        for(int i = 0; i < this.getSize(); i++) {
            String paragraph = "";

            if(this.getOutputMode() == OutputModes.RAW) {
                // FORMAT RAW
                paragraph = String.format("%s: ", (i + 1));                 // line number
                paragraph += String.format("%s\n", this.paragraphs.get(i)); // paragraph
            } else if(this.getOutputMode() == OutputModes.FIX) {
                // FORMAT FIX
                String formattedParagraph = TextFormatter.lineBreak(this.paragraphs.get(i), this.getColumnWidth());
                paragraph = String.format("%s\n", formattedParagraph);
            }

            System.out.print(paragraph);                                    // print paragraph

            // add a space after paragraph, but not at the end of the output.
            if(i < this.getSize() - 1) {
                System.out.print("\n");
            }
        }
    }

    // replace words in the paragraph with the specific index in the notepad
    public void replaceWord(int index, String toReplace, String replaceTo) {
        this.paragraphs.set(index, this.paragraphs.get(index).replaceAll(toReplace, replaceTo));
    }

    // replace words in the paragraph end of the notepad
    public void replaceWord(String toReplace, String replaceTo) {
        this.replaceWord(this.getSize() - 1, toReplace, replaceTo);
    }

    public boolean indexExists(int index) {
        return index <= 0 || index > this.getSize() + 1;
    }

    public List<String> getParagraphs() {
        return this.paragraphs;
    }

    public int getColumnWidth() {
        return this.columnWidth;
    }

    public void setColumnWidth(int columnWidth) {
        this.columnWidth = columnWidth;
    }

    public void setOutputMode(OutputModes outputMode) {
        this.outputMode = outputMode;
    }

    public OutputModes getOutputMode() {
        return outputMode;
    }
}