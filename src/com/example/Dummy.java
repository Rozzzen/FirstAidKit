package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dummy {

    String name;

    private final List<DummyDaughter> children = new ArrayList<>();

    public List<DummyDaughter> getList() {
        return children;
    }


    public Dummy(String name, DummyDaughter ... kids) {
        this.name = name;
        children.addAll(Arrays.asList(kids));
    }
}
