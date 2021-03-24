package com.zhuk.repo;

import com.zhuk.domain.aidkit.FirstAidKit;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("fakeaidkitdb")
public class FakeAidKitDataAcess implements AidKitRepo {

    private List<FirstAidKit> aidKits = new ArrayList<>();
    private Long counter;

    public FakeAidKitDataAcess() {
        aidKits.add(new FirstAidKit(1L,null, null, null, null));
        aidKits.add(new FirstAidKit(2L,null, null, null, null));
        aidKits.add(new FirstAidKit(3L,null, null, null, null));
        aidKits.add(new FirstAidKit(4L,null, null, null, null));
        counter = (long) aidKits.size();
    }

    public FakeAidKitDataAcess(List<FirstAidKit> aidKits) {
        this.aidKits = aidKits;
        counter = (long) aidKits.size();
    }

    @Override
    public List<FirstAidKit> findAllAidKit() {
        return aidKits;
    }

    @Override
    public Optional<FirstAidKit> findAidKitById(Long id) {
        return aidKits.stream().
                filter(aidkit -> aidkit.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteAidKitById(Long id) {
        Optional<FirstAidKit> aidKitMaybe = findAidKitById(id);
        if(!aidKitMaybe.isPresent()) return 0;
        aidKits.remove(aidKitMaybe.get());
        return 1;
    }

    @Override
    public int updateAidKitById(Long id, FirstAidKit firstAidKit) {
        return findAidKitById(id).
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

    @Override
    public void saveAidKit(FirstAidKit firstAidKit) {
        firstAidKit.setId(++counter);
        aidKits.add(firstAidKit);
    }

    @Override
    public void saveAidKit(FirstAidKit firstAidKit, Long id) {
        firstAidKit.setId(id);
        aidKits.add(firstAidKit);
    }
}
