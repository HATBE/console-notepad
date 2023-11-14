package ch.hatbe2113.consoleNotepad.notepad;

import ch.hatbe2113.consoleNotepad.Main;

import java.util.ArrayList;
import java.util.List;

public class NotepadHandler {
    private final Main main;
    private final List<String> paragraphs = new ArrayList<>();

    public NotepadHandler(Main main) {
        this.main = main;
    }

    public void addParagraph(int index, String text) {
        this.paragraphs.add(index, text);
    }

    public void removeParagraph(int index) {
        this.paragraphs.remove(index);
    }

    public int getNotepadSize() {
        return this.paragraphs.size();
    }

    public List<String> getParagraphs() {
        return paragraphs;
    }

    public void print() {
        for(int i = 0; i < paragraphs.size(); i++) {
            System.out.println((i + 1) + ": " + paragraphs.get(i));
        }
    }
}
