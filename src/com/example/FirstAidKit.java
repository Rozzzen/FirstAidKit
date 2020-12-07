package com.example;

import com.example.bandages.Bandage;
import com.example.bandages.BandagingMaterial;
import com.example.exceptions.FirstAidKitException;

import java.util.*;
import java.util.stream.Collectors;

public class FirstAidKit {

    private final List<BandagingMaterial> bandage;
    private CuttingDevice cuttingDevice;
    private Notepad notepad;
    private final Gloves gloves;
    private Pen pen;
    private final List<Garrot> garrot;
    private final List<ARMask> arMask;
    private final List<Dummy> dummyList;

    {
        bandage = new ArrayList<>();
        garrot = new ArrayList<>();
        arMask = new ArrayList<>();
        dummyList = new ArrayList<>();
    }

    public FirstAidKit(BandagingMaterial bandage, CuttingDevice cuttingDevice, Notepad notepad, Pen pen, Garrot garrot, ARMask arMask, Gloves gloves) {
        this.bandage.add(bandage);
        this.cuttingDevice = cuttingDevice;
        this.notepad = notepad;
        this.pen = pen;
        this.garrot.add(garrot);
        this.arMask.add(arMask);
        this.gloves = gloves;
    }

    public List<BandagingMaterial> getBandages() {
        return bandage;
    }

    public List<Dummy> getDummyList() {
        return dummyList;
    }
    public BandagingMaterial getBandage() throws FirstAidKitException {
        if (bandage.isEmpty()) throw new FirstAidKitException("Missing bandage");
        BandagingMaterial temp = bandage.get(bandage.size() - 1);
        bandage.remove(bandage.size() - 1);
        return temp;
    }

    public CuttingDevice getCuttingDevice() throws FirstAidKitException {
        if (cuttingDevice == null) throw new FirstAidKitException("Missing scalpel");
        return cuttingDevice;
    }

    public Gloves getGloves() throws FirstAidKitException {
        if (gloves == null) throw new FirstAidKitException("Missing gloves");
        return gloves;
    }

    public Notepad getNotepad() throws FirstAidKitException {
        if (notepad == null) throw new FirstAidKitException("Missing notepad");
        return notepad;
    }

    public Pen getPen() throws FirstAidKitException {
        if (pen == null) throw new FirstAidKitException("Missing pen");
        return pen;
    }

    public Garrot getGarrot() throws FirstAidKitException {
        if (garrot.isEmpty()) throw new FirstAidKitException("Missing garrot");
        Garrot temp = garrot.get(garrot.size() - 1);
        garrot.remove(garrot.size() - 1);
        return temp;
    }

    public ARMask getArMask() throws FirstAidKitException {
        if (arMask.isEmpty()) throw new FirstAidKitException("Missing mask");
        ARMask temp = arMask.get(arMask.size() - 1);
        arMask.remove(arMask.size() - 1);
        return temp;
    }

    public void add(BandagingMaterial bandagingMaterial) {
        bandage.add(bandagingMaterial);
    }

    public void add(Garrot garrot) {
        this.garrot.add(garrot);
    }

    public void add(ARMask arMask) {
        this.arMask.add(arMask);
    }

    public void add(Dummy dummy) {this.dummyList.add(dummy);}

    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        Iterator<BandagingMaterial> iterator = bandage.iterator();

        stringBuilder.append("First Aid Kit consists of: ").append(System.lineSeparator());

        while (iterator.hasNext()) {
            stringBuilder.append(iterator.next()).append(" ");
        }
        stringBuilder.append(System.lineSeparator());

        stringBuilder.append(cuttingDevice).append(System.lineSeparator());
        stringBuilder.append(notepad).append(System.lineSeparator());
        stringBuilder.append(gloves).append(System.lineSeparator());
        stringBuilder.append(pen).append(System.lineSeparator());
        for (Garrot temp : garrot) {
            stringBuilder.append(temp);
        }
        stringBuilder.append(System.lineSeparator());
        for (ARMask temp : arMask) {
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
                Objects.equals(notepad, that.notepad) &&
                Objects.equals(gloves, that.gloves);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bandage, notepad, gloves);
    }


    public static void main(String[] args) throws FirstAidKitException {
//        Pen redPen = new Pen() {
//            @Override
//            public void write(Notepad notepad, String message) {
//                notepad.writePage(message);
//                System.out.println("Write message using red pen");
//            }
//            @Override
//            public String toString() {return "Red pen";}
//        };
//        Pen pencil = new Pen() {
//            @Override
//            public void write(Notepad notepad, String message) {
//                notepad.writePage(message);
//                System.out.println("Message was written using pencil"); }
//            @Override
//            public String toString() {return "Pencil"; }
//        };
//        CuttingDevice scalpel = new CuttingDevice() {
//            @Override
//            public void cut() { System.out.println("incision was made with a scalpel");}
//            @Override
//            public String toString() {return "Scalpel";}
//        };
//
//        FirstAidKit firstAidKit1 =
//                new FirstAidKit(new Bandage(10, 50, Material.CLOTH), scalpel, new Notepad(50), pencil, new Garrot(), new ARMask(), new Gloves(Material.RUBBER));
//        firstAidKit1.add(new Bandage(20, 100, Material.GAUZE));
//        firstAidKit1.add(new Bandage(30, 150, Material.LEATHER));
//        firstAidKit1.add(new Bandage(10, 70, Material.CLOTH));
//        firstAidKit1.add(new Bandage(20, 80, Material.SILK));
//        firstAidKit1.add(new Bandage(30, 150, Material.SILK));
//        firstAidKit1.dummyList.add(new Dummy("Rachel", new DummyDaughter(1, "John"),
//                new DummyDaughter(2, "Marie")));
//        firstAidKit1.dummyList.add(new Dummy("Michael",new DummyDaughter(1, "Ivan"),
//                new DummyDaughter(2, "Ivanna"),
//                new DummyDaughter(2, "Ivanna"),
//                new DummyDaughter(1, "John"),
//                new DummyDaughter(1, "John")));
//
//        System.out.println(getClothLengthSum(firstAidKit1.getBandages()));
//        System.out.println(getMaxLength(firstAidKit1.getBandages()));
//        System.out.println(getAverageLength(firstAidKit1.getBandages()));
//        System.out.println(getGroupByMaterialAndLength(firstAidKit1.getBandages()));
//        System.out.println(getMostFrequentChildNames(firstAidKit1.dummyList));

    }

    public static List<String> getMostFrequentChildNames(List<Dummy> dummyList) {
        List<String> result = new ArrayList<>();
        dummyList.stream()
                .flatMap(x -> x.getList().stream())
                .collect(Collectors.toList())
                .stream()
                .collect(Collectors.groupingBy(DummyDaughter::getSex))
                .forEach((key, value) -> value.stream()
                        .collect(Collectors.groupingBy(DummyDaughter::getName, Collectors.counting()))
                        .entrySet()
                        .stream()
                        .max(Map.Entry.comparingByValue())
                        .ifPresent(x -> result.add(x.getKey())));
        return result;
    }

    public static int getClothLengthSum(List<BandagingMaterial> list) {
        return list.stream().
                filter(x -> x.getMaterial().equals(Material.CLOTH)).
                mapToInt(BandagingMaterial::getLength).
                sum();
    }

    public static double getAverageLength(List<BandagingMaterial> list) {
        return list.stream().
                mapToInt(BandagingMaterial::getLength).
                average().getAsDouble();
    }

    public static int getMaxLength(List<BandagingMaterial> list) {
        return list.stream().
                mapToInt(BandagingMaterial::getLength).
                max().getAsInt();
    }

    public static Map<Boolean, List<BandagingMaterial>> getGroupByMaterialAndLength(List<BandagingMaterial> list) {
        return list.stream().
                collect(Collectors.groupingBy((p) -> p.getMaterial().equals(Material.CLOTH) && p.getLength() > 30));
    }
}

