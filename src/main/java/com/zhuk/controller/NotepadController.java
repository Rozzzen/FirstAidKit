package com.zhuk.controller;

import com.zhuk.domain.Notepad;
import com.zhuk.service.NotepadService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("notepad")
public class NotepadController {

    private NotepadService notepadService;

    @GetMapping("/number/{i}")
    public List<Notepad> findAllByNumber(@PathVariable Integer i) {
        return notepadService.findAllByPageNumber(i);
    }

    @GetMapping("/")
    public List<Notepad> findAll() {
        return notepadService.findAll();
    }

    @GetMapping("{id}")
    public Notepad findById(@PathVariable Long id) {
        return notepadService.findFirstById(id);
    }

    @PostMapping
    public List<Notepad> save(Notepad notepad) {
        notepadService.save(notepad);
        return notepadService.findAll();
    }

    @PutMapping("{id}")
    public List<Notepad> update(@PathVariable Long id, @RequestBody Notepad notepad) {
        notepadService.update(id, notepad);
        return notepadService.findAll();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        notepadService.delete(id);
    }
}
