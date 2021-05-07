package com.zhuk.service;

import com.zhuk.domain.Gloves;
import com.zhuk.domain.Material;
import com.zhuk.exception.ElementNotFoundException;
import com.zhuk.repo.GlovesRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GlovesService {

    private GlovesRepo glovesRepo;

    public Gloves findFirstById(Long id) {
        return glovesRepo.findById(id).orElseThrow(ElementNotFoundException::new);
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
        glovesRepo.findById(id).orElseThrow(ElementNotFoundException::new);
        gloves.setId(id);
        glovesRepo.save(gloves);
    }

    public void delete(Long id) {
        glovesRepo.findById(id).orElseThrow(ElementNotFoundException::new);
        glovesRepo.deleteById(id);
    }
}
