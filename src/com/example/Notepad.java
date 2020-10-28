package com.example;

public class Notepad {

    private Pen pen;
    private int pageNumber;
    private int index;
    public String[] notepadContent = new String[pageNumber];

    public Notepad(Pen pen, int pageNumber) {
        this.pen = pen;
        this.pageNumber = pageNumber;
    }

    public void writeNote(String text) {
        pen.write();
    }

    public String toString() {
        return "Notepad with " + pageNumber + " pages";
    }
}
