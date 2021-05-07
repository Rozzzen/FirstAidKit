package com.zhuk.controller;

import com.zhuk.domain.Gloves;
import com.zhuk.domain.Material;
import com.zhuk.service.GlovesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("gloves")
public class GlovesController {

    private GlovesService glovesService;

    @GetMapping("/material/{m}")
    public List<Gloves> findAllByMaterial(@PathVariable String m) {
        Material material = Material.valueOf(m.toUpperCase());
        return glovesService.findAllByMaterial(material);
    }

    @GetMapping("/")
    public List<Gloves> findAll() {
        return glovesService.findAll();
    }

    @GetMapping("{id}")
    public Gloves findById(@PathVariable Long id) {
        return glovesService.findFirstById(id);
    }

    @PostMapping
    public List<Gloves> save(Gloves gloves) {
        glovesService.save(gloves);
        return glovesService.findAll();
    }

    @PutMapping("{id}")
    public List<Gloves> update(@PathVariable Long id, @RequestBody Gloves gloves) {
        glovesService.update(id, gloves);
        return glovesService.findAll();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        glovesService.delete(id);
    }
}
