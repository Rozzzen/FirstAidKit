package com.zhuk.service;

import com.zhuk.domain.Notepad;
import com.zhuk.exception.ElementNotFoundException;
import com.zhuk.repo.NotepadRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NotepadService {

    private NotepadRepo notepadRepo;

    public Notepad findFirstById(Long id) {
        return notepadRepo.findById(id).orElseThrow(ElementNotFoundException::new);
    }

    public List<Notepad> findAll() {
        return notepadRepo.findAll();
    }

    public List<Notepad> findAllByPageNumber(Integer pageNumber) {
        return notepadRepo.findAllByPageNumber(pageNumber);
    }

    public void save(Notepad notepad) {
        notepadRepo.save(notepad);
    }

    public void update(Long id, Notepad notepad) {
        notepadRepo.findById(id).orElseThrow(ElementNotFoundException::new);
        notepad.setId(id);
        notepadRepo.save(notepad);
    }

    public void delete(Long id) {
        notepadRepo.findById(id).orElseThrow(ElementNotFoundException::new);
        notepadRepo.deleteById(id);
    }
}
