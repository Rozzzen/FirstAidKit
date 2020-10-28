package com.example;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Garrot {

    private Notepad notepad;
    private LocalTime time;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public void stopBleeding() {
        System.out.println("Bleeding has stopeed");
        setApplicationDate();
    }

    public void setNotepad (Notepad notepad) {this.notepad = notepad;}
    private void setApplicationDate() {
        time = LocalTime.now();
    }

    public String toString() {
        return "Garrot which was installed in " + time;
    }
}
