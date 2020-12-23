//package com.example;
//
//import com.example.components.ARMask;
//import com.example.components.Garrot;
//import com.example.components.Gloves;
//import com.example.components.Notepad;
//import com.example.components.bandages.AdhesivePlaster;
//import com.example.components.bandages.Bandage;
//import com.example.enums.Material;
//import com.example.exceptions.FirstAidKitException;
//import com.example.interfaces.CuttingDevice;
//import com.example.interfaces.Pen;
//
//public class Demo {
//
//    public static void main(String[] args) {
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
//        FirstAidKit firstAidKit1 = new FirstAidKit(new AdhesivePlaster(10, 50, Material.CLOTH, true), scalpel, new Notepad(50), pencil, new Garrot(), new ARMask(), new Gloves(Material.RUBBER));
//        try {
//            firstAidKit1.getGloves().takeOnGloves();
//            pencil.write(firstAidKit1.getNotepad(), "Person is heavy bleeding");
//            firstAidKit1.getGarrot().stopBleeding(firstAidKit1.getNotepad());
//            firstAidKit1.getBandage().bandageWound();
//            firstAidKit1.getCuttingDevice().cut();
//            firstAidKit1.getNotepad().readAll();
//        } catch (FirstAidKitException e) {
//            e.printStackTrace();
//            System.out.println("Adding missing component to Aid kit");
//            String component = e.getMessage().split(" ")[1];
//            switch (component) {
//                case "bandage":
//                    firstAidKit1.add(new Bandage(10, 20, Material.CLOTH, false));
//                    break;
//                case "scalpel":
//                    firstAidKit1.setCuttingDevice(scalpel);
//                    break;
//                case "garrot":
//                    firstAidKit1.add(new Garrot());
//                    break;
//                case "mask":
//                    firstAidKit1.add(new ARMask());
//                    break;
//                case "pen":
//                    firstAidKit1.setPen(pencil);
//                    break;
//                case "notepad":
//                    firstAidKit1.setNotepad(new Notepad(100));
//                    break;
//            }
//        } finally {
//            firstAidKit1.getGloves().takeOffGloves();
//        }
//    }
//}
