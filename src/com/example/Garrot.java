package com.example;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Garrot {

    private LocalTime time;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public void stopBleeding(Notepad notepad) {
        System.out.println("Bleeding has stopeed using garrot");
        setApplicationDate(notepad);
    }

    private void setApplicationDate(Notepad notepad) {
        time = LocalTime.now();
        notepad.writePage("Garrot was installed at: " + formatter.format(time));
    }

    public String toString() {
        return "Garrot which was installed in " + time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Garrot garrot = (Garrot) o;
        return Objects.equals(time, garrot.time) &&
                Objects.equals(formatter, garrot.formatter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, formatter);
    }
}
