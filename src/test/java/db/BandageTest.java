package db;

import com.zhuk.config.Application;
import com.zhuk.controller.BandageController;
import com.zhuk.domain.Bandage;
import com.zhuk.domain.Material;
import com.zhuk.exception.ElementNotFoundException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BandageTest {

    AnnotationConfigApplicationContext context;
    BandageController bandageController;
    List<Bandage> expected = new LinkedList<>();
    Long savedID = null;

    @Before
    public void setUp () {
        context = new AnnotationConfigApplicationContext(Application.class);

        bandageController = context.getBean(BandageController.class);

        expected = bandageController.findAll();
    }

    @Test
    public void findAllBandages_true () {

        List<Bandage> expected1 = new LinkedList<>();
        expected1.add(new Bandage(1L, 10, 10, Material.LEATHER, null));
        expected1.add(new Bandage(2L, 20, 20, Material.CLOTH, null));
        expected1.add(new Bandage(3L, 30, 30, Material.CLOTH, null));

        List<Bandage> actual =bandageController.findAll();

        Assert.assertEquals(expected1,actual);
    }

    @Test
    public void findBandageByID_true () {
        Bandage actual = bandageController.findById(2L);

        Assert.assertEquals(expected.get(1), actual);
    }

    @Test(expected = ElementNotFoundException.class)
    public void findBandageById_false () {
        bandageController.findById(100L);
    }

    @Test
    public void findBandageByMaterial_true () {
        List<Bandage> actual = bandageController.findAllByMaterial(Material.LEATHER.toString());
        Assert.assertEquals(Collections.singletonList(expected.get(0)) , actual);
    }

    @Test
    public void saveBandage_true () {

        Bandage temp = new Bandage(4L, 40, 40, Material.CLOTH, null);
        expected.add(temp);
        bandageController.save(temp);

        List<Bandage> actual = bandageController.findAll();
        savedID = actual.get(actual.size()-1).getId();
        expected.get(expected.size()-1).setId(savedID);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void updateBandage_true () {

        Bandage temp = new Bandage(5L, 50, 50, Material.CLOTH, null);
        bandageController.save(temp);
        List<Bandage> actual = bandageController.findAll();
        savedID = actual.get(actual.size()-1).getId();

        Bandage temp1 = new Bandage(savedID, 60, 60, Material.CLOTH, null);
        expected.add(temp1);

        actual = bandageController.update(savedID, temp1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void deleteBandage_true () {
        Bandage temp = new Bandage(6L, 60, 60, Material.CLOTH, null);

        bandageController.save(temp);
        List<Bandage> actual = bandageController.findAll();
        savedID = actual.get(actual.size()-1).getId();
        bandageController.delete(savedID);
        actual = bandageController.findAll();
        savedID = null;
        Assert.assertEquals(expected, actual);
    }

    @After
    public void tearDown () {
        if (savedID!=null)
            bandageController.delete(savedID);
    }
}
