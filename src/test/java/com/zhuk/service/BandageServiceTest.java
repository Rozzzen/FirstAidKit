package com.zhuk.service;

import com.zhuk.domain.Bandage;
import com.zhuk.domain.Material;
import com.zhuk.repo.BandageRepo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BandageServiceTest {

    @MockBean
    private BandageRepo bandageRepo;

    @Autowired
    private BandageService bandageService;

    @Test
    public void findAllReturnBandageList() {
        Mockito.when(bandageRepo.findAll()).thenReturn(Collections.singletonList(new Bandage(1L, 8, 1000, "test bandage", Material.CLOTH)));
        System.out.println(bandageService.findAll());
        Assert.assertEquals(bandageService.findAll(),Collections.singletonList(new Bandage(1L, 8, 1000, "test bandage", Material.CLOTH)));
    }
}
