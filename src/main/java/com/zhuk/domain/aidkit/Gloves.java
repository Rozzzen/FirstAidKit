package com.zhuk.domain.aidkit;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Gloves {

    private Long id;
    private Material material;
    private boolean equipped;

    public Gloves(Material material) {
        this.material = material;
    }
}
