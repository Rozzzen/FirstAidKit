package com.zhuk.repo;

import com.zhuk.domain.aidkit.FirstAidKit;

import java.util.List;
import java.util.Optional;

//Will extend JPARepo
public interface AidKitRepo {
    int updateAidKitById(Long id, FirstAidKit firstAidKit);
    int deleteAidKitById(Long id);
    Optional<FirstAidKit> findAidKitById(Long id);
    List<FirstAidKit> findAllAidKit();
    void saveAidKit(FirstAidKit firstAidKit);
    void saveAidKit(FirstAidKit firstAidKit, Long id);
}
