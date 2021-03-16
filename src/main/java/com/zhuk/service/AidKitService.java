package com.zhuk.service;

import com.zhuk.domain.aidkit.FirstAidKit;
import com.zhuk.repo.AidKitRepo;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class AidKitService {

    private AidKitRepo aidKitRepo;

    public List<FirstAidKit> findAllAidKit() {
       return aidKitRepo.findAllAidKit();
    }

    public Optional<FirstAidKit> findAidKitById(Long id) {
        return aidKitRepo.findAidKitById(id);
    }

    public int deleteAidKitById(Long id) {
        return aidKitRepo.deleteAidKitById(id);
    }

    public int updateAidKitById(Long id, FirstAidKit firstAidKit) {
        return aidKitRepo.updateAidKitById(id, firstAidKit);
    }

    public void saveAidKit(FirstAidKit firstAidKit) {
        aidKitRepo.saveAidKit(firstAidKit);
    }
}