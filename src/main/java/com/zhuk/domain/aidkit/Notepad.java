package com.zhuk.domain.aidkit;

import lombok.Data;

@Data
public class Notepad {

    private final int pageNumber;
    private int index;
    public String[] notepadContent;

    public Notepad(int pageNumber) {
        this.pageNumber = pageNumber;
        notepadContent = new String[pageNumber];
    }

    public void write(String string) { notepadContent[index++] = string; }
}
