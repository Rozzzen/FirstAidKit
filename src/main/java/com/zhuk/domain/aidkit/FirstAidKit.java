package com.zhuk.domain.aidkit;

import com.zhuk.exception.FirstAidKitException;
import lombok.Data;

import java.util.List;

@Data
public class FirstAidKit {
    private List<Bandage> bandages;
    private Notepad notepad;
    private Gloves gloves;
    private List<Garrot> garrots;

    public Bandage getBandage() throws FirstAidKitException {
        if (bandages.isEmpty()) throw new FirstAidKitException("Missing bandage");
        Bandage temp = bandages.get(bandages.size() - 1);
        bandages.remove(bandages.size() - 1);
        return temp;
    }

    public Gloves getGloves() throws FirstAidKitException {
        if (gloves == null) throw new FirstAidKitException("Missing gloves");
        return gloves;
    }

    public Notepad getNotepad() throws FirstAidKitException {
        if (notepad == null) throw new FirstAidKitException("Missing notepad");
        return notepad;
    }

    public Garrot getGarrot() throws FirstAidKitException {
        if (garrots.isEmpty()) throw new FirstAidKitException("Missing garrot");
        Garrot temp = garrots.get(garrots.size() - 1);
        garrots.remove(garrots.size() - 1);
        return temp;
    }
}