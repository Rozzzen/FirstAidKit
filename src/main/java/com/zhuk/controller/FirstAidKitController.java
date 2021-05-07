package com.zhuk.controller;

import com.zhuk.domain.FirstAidKit;
import com.zhuk.service.FirstAidKitService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("aidkit")
public class FirstAidKitController {

    private FirstAidKitService firstAidKitService;

    @GetMapping("/")
    public List<FirstAidKit> findAll() {
        return firstAidKitService.findAll();
    }

    @GetMapping("{id}")
    public FirstAidKit findById(@PathVariable Long id) {
        return firstAidKitService.findFirstById(id);
    }

    @PostMapping
    public List<FirstAidKit> save(FirstAidKit firstAidKit) {
        firstAidKitService.save(firstAidKit);
        return firstAidKitService.findAll();
    }

    @PutMapping("{id}")
    public List<FirstAidKit> update(@PathVariable Long id, @RequestBody FirstAidKit firstAidKit) {
        firstAidKitService.update(id, firstAidKit);
        return firstAidKitService.findAll();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        firstAidKitService.delete(id);
    }
}
