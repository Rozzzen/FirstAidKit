package com.zhuk.controller;

import com.zhuk.domain.aidkit.FirstAidKit;
import com.zhuk.exception.FirstAidKitException;
import com.zhuk.service.AidKitService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AidKitController {
    private AidKitService aidKitService;

    public void deleteAidKit(Long id) throws Exception {
        if(aidKitService.deleteAidKitById(id) == 0) {
            throw new FirstAidKitException("Failed to delete aidkit");
        }
        else {
            System.out.println("All good");
        }
    }

    public void updateAidKit(Long id, FirstAidKit aidkit) throws Exception {
        if(aidKitService.updateAidKitById(id, aidkit) == 0) {
            throw new FirstAidKitException("Failed to update aidkit");
        }
        else {
            System.out.println("All good");
        }
    }

    public void saveAidKit(FirstAidKit firstAidKit) throws FirstAidKitException {
        if(aidKitService.findAllAidKit().contains(firstAidKit)) {
            throw new FirstAidKitException("this aidkit already exists");
        }
        else {
            aidKitService.saveAidKit(firstAidKit);
            System.out.println("All good");
        }
    }
}
