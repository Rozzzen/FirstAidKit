package com.example;

import com.example.bandages.BandagingMaterial;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FirstAidKit {

    private final List<BandagingMaterial> bandage;
    private final List<CuttingDevice> cuttingDevice;
    private Gloves gloves;
    private Notepad notepad;
    private Pen pen;
    private final List<Garrot> garrot;
    private final List<ARMask> arMask;
    int counter = 0;
    int id = counter++;

    {
        bandage = new ArrayList<>();
        cuttingDevice = new ArrayList<>();
        garrot = new ArrayList<>();
        arMask = new ArrayList<>();
    }

    public FirstAidKit(BandagingMaterial bandage, CuttingDevice cuttingDevice, Gloves gloves, Notepad notepad, Pen pen, Garrot garrot, ARMask arMask) {
        this.bandage.add(bandage);
        this.cuttingDevice.add(cuttingDevice);
        this.gloves = gloves;
        this.notepad = notepad;
        this.pen = pen;
        garrot.setNotepad(this.notepad);
        this.garrot.add(garrot);
        this.arMask.add(arMask);
    }

    public void add(BandagingMaterial bandagingMaterial) { bandage.add(bandagingMaterial); }
    public void add(CuttingDevice cuttingDevice) { this.cuttingDevice.add(cuttingDevice); }
    public void add(Garrot garrot) {this.garrot.add(garrot);}
    public void add(ARMask arMask) {this.arMask.add(arMask);}

    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        Iterator<BandagingMaterial> iterator = bandage.iterator();

        stringBuilder.append("First Aid Kit consists of: ").append(System.lineSeparator());

        while(iterator.hasNext()) {
            stringBuilder.append(iterator.next()).append(" ");
        }

        stringBuilder.append(System.lineSeparator());

        for (CuttingDevice temp: cuttingDevice) {
            stringBuilder.append(temp);
        }
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(gloves).append(System.lineSeparator());;
        stringBuilder.append(notepad).append(System.lineSeparator());;
        stringBuilder.append(pen).append(System.lineSeparator());
        for (Garrot temp: garrot) {
            stringBuilder.append(temp);
        }
        stringBuilder.append(System.lineSeparator());
        for (ARMask temp: arMask) {
            stringBuilder.append(temp);
        }
        return stringBuilder.toString();
    }
}
