package com.zhuk.controller;

import com.zhuk.domain.Gloves;
import com.zhuk.domain.Material;
import com.zhuk.service.GlovesService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("gloves")
public class GlovesController {

    private GlovesService glovesService;

    @GetMapping("/material/{m}")
    public ResponseEntity<List<Gloves>> findAllByMaterial(@PathVariable String m) {
        Material material = Material.valueOf(m.toUpperCase());
        return ResponseEntity.ok(glovesService.findAllByMaterial(material));
    }

    @GetMapping("/")
    public ResponseEntity<List<Gloves>> findAll() {
        return ResponseEntity.ok(glovesService.findAll());
    }

    @GetMapping("{id}")
    public Gloves findById(@PathVariable Long id) {
        return glovesService.findFirstById(id);
    }

    @PostMapping
    public ResponseEntity<Gloves> save(@Valid @RequestBody Gloves gloves) {
        glovesService.save(gloves);
        return ResponseEntity.ok(gloves);
    }

    @PutMapping("{id}")
    public ResponseEntity<Gloves> update(@PathVariable Long id, @RequestBody @Valid Gloves gloves) {
        glovesService.update(id, gloves);
        return ResponseEntity.ok(gloves);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        glovesService.delete(id);
    }
}
