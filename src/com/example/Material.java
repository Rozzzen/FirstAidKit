package com.example;

public enum Material {

    RUBBER ("Rubber"),
    LEATHER ("Leather"),
    CLOTH ("Cloth"),
    GAUZE("Gauze"),
    SILK ("Silk");

    private String material;
//+
    Material(String material) {
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Material material: Material.values()) {
            stringBuilder.append(material.material).append(", ");
        }
        return stringBuilder.toString();
    }

}
