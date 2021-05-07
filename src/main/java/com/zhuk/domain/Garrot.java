package com.zhuk.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Objects;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Table(name = "garrots")
public class Garrot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Range( max = 500, message = "Should be in range[50, 500]")
    private Integer width;

    @Range( max = 500, message = "Should be in range[50, 500]")
    private Integer length;

    @Transient
    private LocalTime setAtTime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "notepad_id", referencedColumnName = "id")
    private Notepad notepad;

    @OneToOne(mappedBy = "notepad")
    private FirstAidKit aidKit;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Garrot garrot = (Garrot) o;
        return Objects.equals(getId(), garrot.getId()) &&
                Objects.equals(getWidth(), garrot.getWidth()) &&
                Objects.equals(getLength(), garrot.getLength()) &&
                Objects.equals(getNotepad(), garrot.getNotepad());
    }

    public Garrot(Long id, @Range(max = 500, message = "Should be in range[50, 500]") Integer width, @Range(max = 500, message = "Should be in range[50, 500]") Integer length, Notepad notepad) {
        this.id = id;
        this.width = width;
        this.length = length;
        this.notepad = notepad;
    }

    //    public void stopBleeding() {
//        System.out.println("Bleeding has stopeed using garrot");
//        setApplicationDate();
//    }

//    private void setApplicationDate() {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
//        time = LocalTime.now();
//        notepad.write("Garrot was installed at: " + formatter.format(time));
//    }
}
