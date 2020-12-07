package com.example;

public class DummyDaughter {

    private final int sex; //1 - male 2 - female
    private final String name;

    public DummyDaughter(int sex, String name) {
        this.sex = sex;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getSex() {
        return sex;
    }
}
