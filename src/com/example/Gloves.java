package com.example;

public class Gloves {
    private final Material material;
    public void wearGloves() {}
    public boolean glovesOn() { return false; }

    public Gloves(Material material) {
        this.material = material;
    }

    public String toString() {
        return "Gloves with material: " + material.getMaterial();
    }
}
