package com.zhuk.service;

import com.zhuk.domain.FirstAidKit;
import com.zhuk.exception.exceptions.AidkitNotFoundException;
import com.zhuk.exception.exceptions.BandageNotFoundException;
import com.zhuk.repo.FirstAidKitRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FirstAidKitService {

    private FirstAidKitRepo firstAidKitRepo;

    public FirstAidKit findFirstById(Long id) {
        return firstAidKitRepo.findById(id).orElseThrow(() -> new AidkitNotFoundException("Failed to find aidkit with id:" + id));
    }

    public List<FirstAidKit> findAll() {
        return firstAidKitRepo.findAll();
    }

    public void save(FirstAidKit firstAidKit) {
        firstAidKitRepo.save(firstAidKit);
    }

    public void update(Long id, FirstAidKit firstAidKit) {
        firstAidKitRepo.findById(id).orElseThrow(() -> new AidkitNotFoundException("Failed to find aidkit with id:" + id));
        firstAidKit.setId(id);
        firstAidKitRepo.save(firstAidKit);
    }

    public void delete(Long id) {
        firstAidKitRepo.findById(id).orElseThrow(() -> new AidkitNotFoundException("Failed to find aidkit with id:" + id));
        firstAidKitRepo.deleteById(id);
    }
}
