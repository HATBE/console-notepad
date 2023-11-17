package ch.hatbe2113.consoleNotepad.notepad;

import ch.hatbe2113.consoleNotepad.util.TextFormatter;

import java.util.*;
import java.util.stream.Collectors;

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

    // print all paragraphs in the given format (this.outputMode)
    public void print() {
        // if notepad is empty, return
        if(this.getSize() <= 0) {
            return;
        }

        for(int i = 0; i < this.getSize(); i++) {
            String paragraph = "";

            if(this.getOutputMode() == OutputModes.RAW) {
                // FORMAT RAW
                paragraph = String.format("%s: ", (i + 1)); // line number
                paragraph += String.format("%s\n", this.paragraphs.get(i)); // paragraph
            } else if(this.getOutputMode() == OutputModes.FIX) {
                // FORMAT FIX
                String formattedParagraph = TextFormatter.lineBreak(this.paragraphs.get(i), this.getColumnWidth()); // run paragraph through line breaker (break at "this.columnWidth'th" char / space before)
                paragraph = String.format("%s\n", formattedParagraph);
            }

            System.out.print(paragraph); // print paragraph

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

    // print index of words that appear more than 3 times in paragraphs
    public boolean printIndex() {
        Map<String, Set<Integer>> index = new HashMap<>(); // String: Word | Int-Set: paragraph numbers in which word is present

        int currentParagraphNumber = 1; // human-readable index (n + 1)

        for(String paragraph : this.getParagraphs()) {
            String[] words = paragraph.split("\\s+"); // split paragraph in words (by one or more spaces)

            for(String word : words) {
                if(Character.isUpperCase(word.charAt(0))) { // check if first char of word is uppercase
                    // this is some senior level dev shit, right?
                    index.computeIfAbsent(word, k -> new HashSet<>()).add(currentParagraphNumber); // if word is not in index map, add its paragraph number to index map
                    // Hey Alex, don't steal my CODE!!!!! xD
                }
            }

            currentParagraphNumber++;
        }

        int numOfIndexes = 0;

        for(Map.Entry<String, Set<Integer>> entry : index.entrySet()) {
            // check if word count is over 3, then, add to index
            if(entry.getValue().size() >= 3) {
                // sometimes, my genius, its, its almost frightening
                String paragraphList = entry.getValue().stream().map(String::valueOf).collect(Collectors.joining(",")); // transform the values of the "paragraph numbers" collection to a comma separated list

                System.out.print(entry.getKey() + " \t"); // word
                System.out.println(paragraphList); // list of paragraph numbers the word occurs
                numOfIndexes++;
            }
        }

        return numOfIndexes != 0; // if no word is index worthy, return false, otherwise, true
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