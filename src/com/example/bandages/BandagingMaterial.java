package com.example.bandages;

import com.example.Material;

public abstract class BandagingMaterial {
    protected final int width;
    protected final int length;
    protected Material material;
//+
    public abstract void bandageWound();

    protected BandagingMaterial(int width, int length, Material material) {
        this.width = width;
        this.length = length;
        this.material = material;
    }

    public String toString() {
    return "Bandage with width: " + width +
            " length: " + length +
            " material: " + material.getMaterial();
    }
}
