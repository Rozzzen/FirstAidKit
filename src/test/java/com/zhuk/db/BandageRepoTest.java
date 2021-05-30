package com.zhuk.db;

import com.zhuk.domain.Bandage;
import com.zhuk.domain.Material;
import com.zhuk.repo.BandageRepo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BandageRepoTest {

    @Autowired
    private BandageRepo bandageRepo;

    private List<Bandage> bandageList;

    @Before
    public void setUp() {
        bandageList = new ArrayList<>(Arrays.asList(
                new Bandage(1L, 8, 1000, "BandageUA", Material.CLOTH),
                new Bandage(2L, 13, 1500, "Tight Bandage", Material.SILK),
                new Bandage(3L, 15, 750, "Wide bandage", Material.CLOTH),
                new Bandage(4L, 18, 1750, "Large Bandage", Material.CLOTH)
        ));
    }

    @Test
    public void findAllReturnsBandageListTest() {
        List<Bandage> expected = bandageList;
        List<Bandage> actual = bandageRepo.findAll();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findAllByMaterialReturnsBandageListTest() {
        Material filterBy = Material.CLOTH;

        List<Bandage> expected = bandageList.stream().filter(x -> x.getMaterial() == filterBy)
                .collect(Collectors.toList());
        List<Bandage> actual = bandageRepo.findAllByMaterial(filterBy);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findFirstByIdReturnBandageTest() {
        Bandage expected = bandageList.get(0);
        Bandage actual = bandageRepo.findById(1L).get();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void saveBandageTest() {
        Bandage bandage = new Bandage(5L, 8, 1000, "Test bandage", Material.CLOTH);

        bandageList.add(bandage);
        bandageRepo.save(bandage);

        List<Bandage> expected = bandageList;
        List<Bandage> actual = bandageRepo.findAll();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void deleteBandageTest() {
        bandageList.remove(3);
        bandageRepo.deleteById(4L);

        List<Bandage> expected = bandageList;
        List<Bandage> actual = bandageRepo.findAll();
        Assert.assertEquals(expected, actual);
    }
}
