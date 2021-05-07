package com.zhuk.controller;

import com.zhuk.domain.Garrot;
import com.zhuk.service.GarrotService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("garrot")
public class GarrotController {

    private GarrotService garrotService;

    @GetMapping("/")
    public List<Garrot> findAll() {
        return garrotService.findAll();
    }

    @GetMapping("{id}")
    public Garrot findById(@PathVariable Long id) {
        return garrotService.findFirstById(id);
    }

    @PostMapping
    public List<Garrot> save(Garrot garrot) {
        garrotService.save(garrot);
        return garrotService.findAll();
    }

    @PutMapping("{id}")
    public List<Garrot> update(@PathVariable Long id, @RequestBody Garrot garrot) {
        garrotService.update(id, garrot);
        return garrotService.findAll();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        garrotService.delete(id);
    }
}
