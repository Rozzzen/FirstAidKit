package com.zhuk.controller;

import com.zhuk.domain.FirstAidKit;
import com.zhuk.service.FirstAidKitService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("aidkits")
public class FirstAidKitController {

    private FirstAidKitService firstAidKitService;

    @GetMapping("{id}")
    public ResponseEntity<FirstAidKit> findById(@PathVariable Long id) {
        return ResponseEntity.ok(firstAidKitService.findFirstById(id));
    }

    @PostMapping
    public ResponseEntity<FirstAidKit> save(@Valid @RequestBody FirstAidKit firstAidKit) {
        firstAidKitService.save(firstAidKit);
        return ResponseEntity.ok(firstAidKit);
    }

    @PutMapping("{id}")
    public ResponseEntity<FirstAidKit> update(@PathVariable Long id, @RequestBody @Valid FirstAidKit firstAidKit) {
        firstAidKitService.update(id, firstAidKit);
        return ResponseEntity.ok(firstAidKit);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        firstAidKitService.delete(id);
    }
}
