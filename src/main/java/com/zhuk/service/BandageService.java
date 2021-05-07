package com.zhuk.service;

import com.zhuk.domain.Bandage;
import com.zhuk.domain.Material;
import com.zhuk.exception.ElementNotFoundException;
import com.zhuk.repo.BandageRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BandageService {

    private BandageRepo bandageRepo;

    public Bandage findFirstById(Long id) {
        return bandageRepo.findById(id).orElseThrow(ElementNotFoundException::new);
    }

    public List<Bandage> findAll() {
        return bandageRepo.findAll();
    }

    public List<Bandage> findAllByMaterial(Material material) {
        return bandageRepo.findAllByMaterial(material);
    }

    public void save(Bandage bandage) {
        bandageRepo.save(bandage);
    }

    public void update(Long id, Bandage bandage) {
        bandageRepo.findById(id).orElseThrow(ElementNotFoundException::new);
        bandage.setId(id);
        bandageRepo.save(bandage);
    }

    public void delete(Long id) {
        bandageRepo.findById(id).orElseThrow(ElementNotFoundException::new);
        bandageRepo.deleteById(id);
    }
}
