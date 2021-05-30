package com.zhuk.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;
import java.util.Objects;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@ToString(exclude = {"aidKit"})
@Table(name = "garrots")
public class Garrot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Range(min = 7, max = 20, message = "Should be in range[7, 20]")
    @NotNull
    private Integer width;

    @Range(min = 500, max = 2000, message = "Should be in range[500, 2000]")
    @NotNull
    private Integer length;

    @Column(unique = true)
    @NotBlank
    private String name;

    @Transient
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    private LocalTime setAtTime;
}
