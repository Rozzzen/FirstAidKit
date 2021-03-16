package com.zhuk.domain.aidkit;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Bandage {

    private Long id;
    private int width;
    private int length;
    protected Material material;
    private boolean sterile;

}
