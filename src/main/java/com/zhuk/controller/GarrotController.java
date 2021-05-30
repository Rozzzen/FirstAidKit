package com.zhuk.controller;

import com.zhuk.domain.Garrot;
import com.zhuk.service.GarrotService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("garrots")
public class GarrotController {

    private GarrotService garrotService;

    @GetMapping("/")
    public ResponseEntity<List<Garrot>> findAll() {
        return ResponseEntity.ok(garrotService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Garrot> findById(@PathVariable Long id) {
        return ResponseEntity.ok(garrotService.findFirstById(id));
    }

    @PostMapping
    public ResponseEntity<Garrot> save(@Valid @RequestBody Garrot garrot) {
        garrotService.save(garrot);
        return ResponseEntity.ok(garrot);
    }

    @PutMapping("{id}")
    public ResponseEntity<Garrot> update(@PathVariable Long id, @RequestBody @Valid Garrot garrot) {
        garrotService.update(id, garrot);
        return ResponseEntity.ok(garrot);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        garrotService.delete(id);
    }
}
