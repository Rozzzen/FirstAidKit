package com.example;

import com.example.bandages.BandagingMaterial;
import com.example.exceptions.FirstAidKitException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class FirstAidKit {

    public class Gloves {
        private final Material material;
        private boolean equipped;
        public void takeOnGloves() {equipped = true;}
        public void takeOffGloves() {equipped = false;}
        public boolean glovesOn() { return equipped; }

        public Gloves(Material material) {
            this.material = material;
        }

        public String toString() {
            return "Gloves with material: " + material.getMaterial();
        }
    }


    private final List<BandagingMaterial> bandage;
    private CuttingDevice cuttingDevice;
    private Notepad notepad;
    private Pen pen;
    private final List<Garrot> garrot;
    private final List<ARMask> arMask;

    {
        bandage = new ArrayList<>();
        garrot = new ArrayList<>();
        arMask = new ArrayList<>();
    }

    public FirstAidKit(BandagingMaterial bandage, CuttingDevice cuttingDevice, Notepad notepad, Pen pen, Garrot garrot, ARMask arMask) {
        this.bandage.add(bandage);
        this.cuttingDevice = cuttingDevice;
        this.notepad = notepad;
        this.pen = pen;
        this.garrot.add(garrot);
        this.arMask.add(arMask);
    }

    public BandagingMaterial getBandage() throws FirstAidKitException{
        if(bandage.isEmpty()) throw new FirstAidKitException("Missing bandage");
        BandagingMaterial temp = bandage.get(bandage.size() - 1);
        bandage.remove(bandage.size() - 1);
        return temp;
    }

    public CuttingDevice getCuttingDevice() throws FirstAidKitException{
        if(cuttingDevice == null) throw new FirstAidKitException("Missing scalpel");
        return cuttingDevice;
    }

    public Notepad getNotepad() throws FirstAidKitException {
        if(notepad == null) throw new FirstAidKitException("Missing notepad");
        return notepad;
    }

    public Pen getPen() throws FirstAidKitException {
        if(pen == null) throw new FirstAidKitException("Missing pen");
        return pen;
    }

    public Garrot getGarrot() throws FirstAidKitException {
        if(garrot.isEmpty()) throw new FirstAidKitException("Missing garrot");
        Garrot temp = garrot.get(garrot.size() - 1);
        garrot.remove(garrot.size() - 1);
        return temp;
    }

    public ARMask getArMask() throws FirstAidKitException {
        if(arMask.isEmpty()) throw new FirstAidKitException("Missing mask");
        ARMask temp = arMask.get(arMask.size() - 1);
        arMask.remove(arMask.size() - 1);
        return temp;
    }

    public void setCuttingDevice(CuttingDevice cuttingDevice) {
        this.cuttingDevice = cuttingDevice;
    }

    public void setNotepad(Notepad notepad) {
        this.notepad = notepad;
    }

    public void setPen(Pen pen) {
        this.pen = pen;
    }

    public void add(BandagingMaterial bandagingMaterial) { bandage.add(bandagingMaterial); }
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

        stringBuilder.append(cuttingDevice).append(System.lineSeparator());
        stringBuilder.append(notepad).append(System.lineSeparator());
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FirstAidKit that = (FirstAidKit) o;
        return Objects.equals(bandage, that.bandage) &&
                Objects.equals(cuttingDevice, that.cuttingDevice) &&
                Objects.equals(notepad, that.notepad) &&
                Objects.equals(pen, that.pen) &&
                Objects.equals(garrot, that.garrot) &&
                Objects.equals(arMask, that.arMask);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bandage, cuttingDevice, notepad, pen, garrot, arMask);
    }
}
