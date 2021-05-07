package com.zhuk.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.util.Objects;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Table(name = "notepads")
public class Notepad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "page_number")
    @Range( max = 500, message = "Should be in range[50, 500]")
    private Integer pageNumber;

    @OneToOne(mappedBy = "notepad")
    private FirstAidKit aidKit;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notepad notepad = (Notepad) o;
        return Objects.equals(getId(), notepad.getId()) &&
                Objects.equals(getPageNumber(), notepad.getPageNumber());
    }

}
