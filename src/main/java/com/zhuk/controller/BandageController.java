package com.zhuk.controller;

import com.zhuk.domain.Bandage;
import com.zhuk.domain.Material;
import com.zhuk.service.BandageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("bandage")
public class BandageController {

    private BandageService bandageService;

    @GetMapping("/material/{m}")
    public List<Bandage> findAllByMaterial(@PathVariable String m) {
        Material material = Material.valueOf(m.toUpperCase());
        return bandageService.findAllByMaterial(material);
    }

    @GetMapping("/")
    public List<Bandage> findAll() {
        return bandageService.findAll();
    }

    @GetMapping("{id}")
    public Bandage findById(@PathVariable Long id) {
        return bandageService.findFirstById(id);
    }

    @PostMapping
    public List<Bandage> save(Bandage bandage) {
        bandageService.save(bandage);
        return bandageService.findAll();
    }

    @PutMapping("{id}")
    public List<Bandage> update(@PathVariable Long id, @RequestBody Bandage bandage) {
        bandageService.update(id, bandage);
        return bandageService.findAll();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
       bandageService.delete(id);
    }
}
