package com.zhuk.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Table(name = "bandages")
public class Bandage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Range( max = 500, message = "Should be in range[50, 500]")
    private Integer width;

    @Range( max = 500, message = "Should be in range[50, 500]")
    private Integer length;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Material material;

    @OneToOne(mappedBy = "notepad")
    private FirstAidKit aidKit;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bandage bandage = (Bandage) o;
        return Objects.equals(getId(), bandage.getId()) &&
                Objects.equals(getWidth(), bandage.getWidth()) &&
                Objects.equals(getLength(), bandage.getLength()) &&
                getMaterial() == bandage.getMaterial();
    }
}
