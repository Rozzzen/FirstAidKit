package com.zhuk.domain.aidkit;

import lombok.Data;

@Data
public class Bandage {

    private int width;
    private int length;
    protected Material material;
    private boolean sterile;

}
