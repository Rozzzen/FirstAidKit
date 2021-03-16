package com.zhuk.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class Role {
    private String id;
    private Set<Privilege> privileges;
}
