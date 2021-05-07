package com.zhuk.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Table(name = "aidkits")
public class FirstAidKit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bandage_id", referencedColumnName = "id")
    private Bandage bandage;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "notepad_id", referencedColumnName = "id")
    private Notepad notepad;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gloves_id", referencedColumnName = "id")
    private Gloves gloves;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "garrot_id", referencedColumnName = "id")
    private Garrot garrots;

    @OneToOne(mappedBy = "aidKit")
    private Order order;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FirstAidKit that = (FirstAidKit) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getBandage(), that.getBandage()) &&
                Objects.equals(getNotepad(), that.getNotepad()) &&
                Objects.equals(getGloves(), that.getGloves()) &&
                Objects.equals(getGarrots(), that.getGarrots());
    }

    //    public Bandage getBandage() throws FirstAidKitException {
//        if (bandages.isEmpty()) throw new FirstAidKitException("Missing bandage");
//        Bandage temp = bandages.get(bandages.size() - 1);
//        bandages.remove(bandages.size() - 1);
//        return temp;
//    }
//
//    public Gloves getGloves() throws FirstAidKitException {
//        if (gloves == null) throw new FirstAidKitException("Missing gloves");
//        return gloves;
//    }
//
//    public Notepad getNotepad() throws FirstAidKitException {
//        if (notepad == null) throw new FirstAidKitException("Missing notepad");
//        return notepad;
//    }
//
//    public Garrot getGarrot() throws FirstAidKitException {
//        if (garrots.isEmpty()) throw new FirstAidKitException("Missing garrot");
//        Garrot temp = garrots.get(garrots.size() - 1);
//        garrots.remove(garrots.size() - 1);
//        return temp;
//    }
//
//    public void add(Bandage bandagingMaterial) {
//        bandages.add(bandagingMaterial);
//    }
//
//    public void add(Garrot garrot) {
//        this.garrots.add(garrot);
//    }
}
