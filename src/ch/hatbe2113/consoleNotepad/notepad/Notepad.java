package ch.hatbe2113.consoleNotepad.notepad;

import ch.hatbe2113.consoleNotepad.Main;

import java.util.ArrayList;
import java.util.List;

public class Notepad {
    private final Main main;
    private final List<String> paragraphs = new ArrayList<>();
    private int columnWidth = -1; //
    private boolean lineNumbersDisplayed = true; // display line numbers as default

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

            if(this.getLineNumbersDisplayed()) {
                paragraph +=  String.format("%s: ", (i + 1));
            }

            paragraph += String.format("%s\n\n", this.paragraphs.get(i));

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

    public boolean getLineNumbersDisplayed() {
        return this.lineNumbersDisplayed;
    }

    public void setLineNumbersDisplayed(boolean lineNumbersDisplayed) {
        this.lineNumbersDisplayed = lineNumbersDisplayed;
    }
}
