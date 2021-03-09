package com.zhuk.domain.aidkit;

import lombok.Data;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Data
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
}
