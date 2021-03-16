package com.zhuk.service;

import com.zhuk.domain.aidkit.FirstAidKit;
import com.zhuk.repo.AidKitRepo;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class AidKitService {

    private AidKitRepo aidKitRepo;

    public List<FirstAidKit> selectAllAidKit() {
       return aidKitRepo.selectAllAidKit();
    }

    public Optional<FirstAidKit> selectAidKitById(Long id) {
        return aidKitRepo.selectAidKitById(id);
    }

    public int deleteAidKitById(Long id) {
        return aidKitRepo.deleteAidKitById(id);
    }

    public int updateAidKitById(Long id, FirstAidKit firstAidKit) {
        return aidKitRepo.updateAidKitById(id, firstAidKit);
    }

}