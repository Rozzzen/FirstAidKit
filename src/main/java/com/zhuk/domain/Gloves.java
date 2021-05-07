package com.zhuk.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Table(name = "gloves")
public class Gloves {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Material material;

    @Transient
    private Boolean equipped;

    @OneToOne(mappedBy = "gloves")
    private FirstAidKit aidKit;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gloves gloves = (Gloves) o;
        return Objects.equals(getId(), gloves.getId()) &&
                getMaterial() == gloves.getMaterial();
    }

}
