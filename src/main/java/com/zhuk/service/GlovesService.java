package com.zhuk.service;

import com.zhuk.domain.Gloves;
import com.zhuk.domain.Material;
import com.zhuk.exception.exceptions.BandageNotFoundException;
import com.zhuk.exception.exceptions.GlovesNotFoundException;
import com.zhuk.repo.GlovesRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GlovesService {

    private GlovesRepo glovesRepo;

    public Gloves findFirstById(Long id) {
        return glovesRepo.findById(id).orElseThrow(() -> new GlovesNotFoundException("Failed to find gloves with id:" + id));
    }

    public List<Gloves> findAll() {
        return glovesRepo.findAll();
    }

    public List<Gloves> findAllByMaterial(Material material) {
        return glovesRepo.findAllByMaterial(material);
    }

    public void save(Gloves gloves) {
        glovesRepo.save(gloves);
    }

    public void update(Long id, Gloves gloves) {
        glovesRepo.findById(id).orElseThrow(() -> new GlovesNotFoundException("Failed to find gloves with id:" + id));
        gloves.setId(id);
        glovesRepo.save(gloves);
    }

    public void delete(Long id) {
        glovesRepo.findById(id).orElseThrow(() -> new GlovesNotFoundException("Failed to find gloves with id:" + id));
        glovesRepo.deleteById(id);
    }
}
