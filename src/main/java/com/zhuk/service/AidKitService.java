package com.zhuk.service;

import com.zhuk.domain.aidkit.FirstAidKit;
import com.zhuk.repo.AidKitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AidKitService {

    private final AidKitRepo aidKitRepo;

    @Autowired
    public AidKitService(@Qualifier("fakeaidkitdb") AidKitRepo aidKitRepo) {
        this.aidKitRepo = aidKitRepo;
    }

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
    public void saveAidKit(FirstAidKit firstAidKit, Long id) {
        aidKitRepo.saveAidKit(firstAidKit, id);
    }
}