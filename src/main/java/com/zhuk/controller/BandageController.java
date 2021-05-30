package com.zhuk.controller;

import com.zhuk.domain.Bandage;
import com.zhuk.domain.Material;
import com.zhuk.service.BandageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("bandages")
public class BandageController {

    private BandageService bandageService;

    @GetMapping("/material/{m}")
    public ResponseEntity<List<Bandage>> findAllByMaterial(@PathVariable String m) {
        Material material = Material.valueOf(m.toUpperCase());
        return ResponseEntity.ok(bandageService.findAllByMaterial(material));
    }

    @GetMapping("/")
    public ResponseEntity<List<Bandage>> findAll() {
        return ResponseEntity.ok(bandageService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Bandage> findById(@PathVariable Long id) {
        return ResponseEntity.ok(bandageService.findFirstById(id));
    }

    @PostMapping
    public ResponseEntity<Bandage> save(@Valid @RequestBody Bandage bandage) {
        bandageService.save(bandage);
        System.out.println("HEYYYYYYYYYY");
        return ResponseEntity.status(HttpStatus.CREATED).body(bandage);
    }

    @PutMapping("{id}")
    public ResponseEntity<Bandage> update(@PathVariable Long id, @RequestBody @Valid Bandage bandage) {
        bandageService.update(id, bandage);
        return ResponseEntity.ok(bandage);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
       bandageService.delete(id);
    }
}
