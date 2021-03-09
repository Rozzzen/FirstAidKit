package com.zhuk.domain.aidkit;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
public class Garrot {

    private int width;
    private int length;
    private LocalTime time;
    private boolean sterile;
    private Notepad notepad;

    public void stopBleeding() {
        System.out.println("Bleeding has stopeed using garrot");
        setApplicationDate();
    }

    private void setApplicationDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        time = LocalTime.now();
        notepad.write("Garrot was installed at: " + formatter.format(time));
    }

    public Garrot(int width, int length, Notepad notepad) {
        this.width = width;
        this.length = length;
        this.notepad = notepad;
    }
}
