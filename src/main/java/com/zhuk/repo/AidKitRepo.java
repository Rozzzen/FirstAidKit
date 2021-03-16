package com.zhuk.repo;

import com.zhuk.domain.aidkit.FirstAidKit;

import java.util.List;
import java.util.Optional;

//Will extend JPARepo
public interface AidKitRepo {
    int updateAidKitById(Long id, FirstAidKit firstAidKit);
    int deleteAidKitById(Long id);
    Optional<FirstAidKit> selectAidKitById(Long id);
    List<FirstAidKit> selectAllAidKit();
}
