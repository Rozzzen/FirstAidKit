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
@Table(name = "aidkits",
uniqueConstraints = {@UniqueConstraint(columnNames = {"bandage_id", "gloves_id", "garrot_id"})})
public class FirstAidKit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotBlank
    private String name;

    @OneToOne()
    @JoinColumn(name = "bandage_id", referencedColumnName = "id")
    @NotNull
    private Bandage bandage;

    @OneToOne()
    @JoinColumn(name = "gloves_id", referencedColumnName = "id")
    @NotNull
    private Gloves gloves;

    @OneToOne()
    @JoinColumn(name = "garrot_id", referencedColumnName = "id")
    @NotNull
    private Garrot garrot;

    @OneToOne(mappedBy = "aidKit")
    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Order order;
}
