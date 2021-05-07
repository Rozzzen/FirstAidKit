package com.zhuk.service;

import com.zhuk.domain.Garrot;
import com.zhuk.exception.ElementNotFoundException;
import com.zhuk.repo.GarrotRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GarrotService {

    private GarrotRepo garrotRepo;

    public Garrot findFirstById(Long id) {
        return garrotRepo.findById(id).orElseThrow(ElementNotFoundException::new);
    }

    public List<Garrot> findAll() {
        return garrotRepo.findAll();
    }

    public void save(Garrot garrot) {
        garrotRepo.save(garrot);
    }

    public void update(Long id, Garrot garrot) {
        garrotRepo.findById(id).orElseThrow(ElementNotFoundException::new);
        garrot.setId(id);
        garrotRepo.save(garrot);
    }

    public void delete(Long id) {
        garrotRepo.findById(id).orElseThrow(ElementNotFoundException::new);
        garrotRepo.deleteById(id);
    }
}
