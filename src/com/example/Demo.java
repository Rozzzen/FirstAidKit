package com.example;

import com.example.bandages.AdhesivePlaster;
import com.example.bandages.GauzeNapkin;

public class Demo {
    public static void main(String[] args) {
        Pen redPen = new Pen() {
            Notepad notepad;
            @Override
            public void write() { System.out.println("Message was written using red pen"); }
            @Override
            public String toString() {return "Red pen";}
        };
        Pen pencil = new Pen() {
            Notepad notepad;
            @Override
            public void write() { System.out.println("Message was written using pencil"); }
            @Override
            public String toString() {return "Pencil"; }
        };
        CuttingDevice scalpel = new CuttingDevice() {
            @Override
            public void cut() { System.out.println("incision was made with a scalpel");}
            @Override
            public String toString() {return "Scalpel";}
        };//+
        CuttingDevice knife = new CuttingDevice() {
            @Override
            public void cut() { System.out.println("incision was made with a scalpel"); }
            @Override
            public String toString() { return "Knife"; }
        };
        FirstAidKit firstAidKit1 = new FirstAidKit(new AdhesivePlaster(10, 50, Material.CLOTH), scalpel, new Gloves(Material.RUBBER), new Notepad(pencil, 50), pencil, new Garrot(), new ARMask());
        System.out.println(firstAidKit1);
        FirstAidKit firstAidKit2 = new FirstAidKit(new GauzeNapkin(5, 10, Material.GAUZE), scalpel, new Gloves(Material.LEATHER), new Notepad(redPen, 25), redPen, new Garrot(), new ARMask());
        System.out.println(firstAidKit2);
        System.out.println(firstAidKit1.equals(firstAidKit2));
        System.out.println(firstAidKit1.hashCode() == firstAidKit2.hashCode());
        FirstAidKit firstAidKit3 = firstAidKit1;
        System.out.println(firstAidKit1.equals(firstAidKit3));
        System.out.println(firstAidKit1.hashCode() == firstAidKit3.hashCode());
        System.out.println();
    }
}
