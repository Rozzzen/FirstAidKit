package com.zhuk.repo;

import com.zhuk.domain.aidkit.FirstAidKit;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class FakeAidKitDataAcess implements AidKitRepo {

    private List<FirstAidKit> aidKits;

    @Override
    public List<FirstAidKit> selectAllAidKit() {
        return aidKits;
    }

    @Override
    public Optional<FirstAidKit> selectAidKitById(Long id) {
        return aidKits.stream().
                filter(aidkit -> aidkit.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteAidKitById(Long id) {
        Optional<FirstAidKit> aidKitMaybe = selectAidKitById(id);
        if(!aidKitMaybe.isPresent()) return 0;
        aidKits.remove(aidKitMaybe.get());
        return 1;
    }

    @Override
    public int updateAidKitById(Long id, FirstAidKit firstAidKit) {
        return selectAidKitById(id).
                map(aidkit -> {
                    int indexOfAidKitToDelete = aidKits.indexOf(aidkit);
                    if (indexOfAidKitToDelete >= 0) {
                        aidKits.set(indexOfAidKitToDelete, firstAidKit);
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
