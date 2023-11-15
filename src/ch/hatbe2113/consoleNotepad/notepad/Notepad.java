package ch.hatbe2113.consoleNotepad.notepad;

import ch.hatbe2113.consoleNotepad.Main;
import ch.hatbe2113.consoleNotepad.util.TextFormatter;

import java.util.ArrayList;
import java.util.List;

public class Notepad {
    public enum OutPut {
        RAW,
        FIX
    }

    private final Main main;
    private final List<String> paragraphs = new ArrayList<>();
    private int columnWidth = -1; //
    private OutPut outputMode = OutPut.RAW;

    public Notepad(Main main) {
        this.main = main;
    }

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
        this.paragraphs.remove(this.getSize() - 1);
    }

    public int getSize() {
        return this.paragraphs.size();
    }

    public void print() {
        // TODO: column width;
        for(int i = 0; i < this.paragraphs.size(); i++) {
            String paragraph = "";

            if(this.getOutputMode() == OutPut.RAW) {
                paragraph +=  String.format("%s: ", (i + 1));
                paragraph += String.format("%s\n\n", this.paragraphs.get(i));
            } else if(this.getOutputMode() == OutPut.FIX) {
                paragraph = TextFormatter.lineBreak(this.paragraphs.get(i), this.getColumnWidth());
                paragraph = String.format("%s\n\n", paragraph);
            }

            System.out.print(paragraph);
        }
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

    public void setOutputMode(OutPut outputMode) {
        this.outputMode = outputMode;
    }

    public OutPut getOutputMode() {
        return outputMode;
    }
}
