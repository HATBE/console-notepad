package ch.hatbe2113.consoleNotepad.notepad;

import ch.hatbe2113.consoleNotepad.Main;

import java.util.ArrayList;
import java.util.List;

public class NotePad {
    private final Main main;
    private final List<String> paragraphs = new ArrayList<>();
    private int columnWidth = 0;

    public NotePad(Main main) {
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

    public void removeParagraph(int index) {
        this.paragraphs.remove(index);
    }

    public int getSize() {
        return this.paragraphs.size();
    }

    public void print() {
        for(int i = 0; i < this.paragraphs.size(); i++) {
            System.out.println((i + 1) + ": " + this.paragraphs.get(i));
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
}
