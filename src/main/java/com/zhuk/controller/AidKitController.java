package com.zhuk.controller;

import com.zhuk.domain.aidkit.FirstAidKit;
import com.zhuk.exception.aidkit.AidKitAlreadyExistsException;
import com.zhuk.exception.aidkit.AidKitNotFoundException;
import com.zhuk.service.AidKitService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("aidkit")
public class AidKitController {

    private final AidKitService aidKitService;

    @GetMapping
    public List<FirstAidKit> AidkitList() {
        return aidKitService.findAllAidKit();
    }

    @GetMapping("{id}")
    public FirstAidKit AidKitById(@PathVariable Long id) throws AidKitNotFoundException {
        return aidKitService.findAidKitById(id).orElseThrow(AidKitNotFoundException::new);
    }

    @PutMapping("{id}")
    public List<FirstAidKit> updateAidKit(@PathVariable Long id, @RequestBody FirstAidKit aidkit) {
        if(aidKitService.findAidKitById(id).isPresent()) {
            aidKitService.updateAidKitById(id, aidkit);
        }
        else {
            aidKitService.saveAidKit(aidkit, id);
        }
        return aidKitService.findAllAidKit();
    }

    @DeleteMapping("{id}")
    public List<FirstAidKit> deleteAidKit(@PathVariable Long id) {
        aidKitService.deleteAidKitById(id);
        return aidKitService.findAllAidKit();
    }

    @PostMapping
    public List<FirstAidKit> saveAidKit(@RequestBody FirstAidKit aidKit) throws AidKitAlreadyExistsException {
        if(aidKitService.findAllAidKit().contains(aidKit)) {
            throw new AidKitAlreadyExistsException("This aidkit already exists");
        }
        else {
            aidKitService.saveAidKit(aidKit);
            return aidKitService.findAllAidKit();
        }
    }
}
