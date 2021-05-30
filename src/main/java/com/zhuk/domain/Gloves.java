package com.zhuk.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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

    @Column(unique = true)
    @NotBlank
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Material material;

    @Transient
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private Boolean equipped;
}
