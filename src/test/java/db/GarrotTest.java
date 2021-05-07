package db;

import com.zhuk.config.Application;
import com.zhuk.controller.BandageController;
import com.zhuk.controller.GarrotController;
import com.zhuk.domain.Bandage;
import com.zhuk.domain.Garrot;
import com.zhuk.domain.Material;
import com.zhuk.domain.Notepad;
import com.zhuk.exception.ElementNotFoundException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class GarrotTest {

    AnnotationConfigApplicationContext context;
    GarrotController garrotController;
    List<Garrot> expected = new LinkedList<>();
    Long savedID = null;

    @Before
    public void setUp () {
        context = new AnnotationConfigApplicationContext(Application.class);

        garrotController = context.getBean(GarrotController.class);

        expected = garrotController.findAll();
    }

    @Test
    public void findAllGarrots_true () {

        List<Garrot> expected1 = new LinkedList<>();
        expected1.add(new Garrot(1L, 10, 10, new Notepad(1L, 100, null)));
        expected1.add(new Garrot(2L, 20, 20, new Notepad(2L, 200, null)));
        expected1.add(new Garrot(3L, 30, 30, new Notepad(3L, 300, null)));

        List<Garrot> actual = garrotController.findAll();

        Assert.assertEquals(expected1,actual);
    }

    @Test
    public void findGarrotByID_true () {
        Garrot actual = garrotController.findById(2L);

        Assert.assertEquals(expected.get(1), actual);
    }

    @Test(expected = ElementNotFoundException.class)
    public void findGarrotById_false () {
        garrotController.findById(100L);
    }

    @Test
    public void saveGarrot_true () {

        Garrot temp = new Garrot(4L, 10, 10, new Notepad(1L, 100, null));
        expected.add(temp);
        garrotController.save(temp);

        List<Garrot> actual = garrotController.findAll();
        savedID = actual.get(actual.size()-1).getId();
        expected.get(expected.size()-1).setId(savedID);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void updateGarrot_true () {

        Garrot temp = new Garrot(5L, 10, 10, new Notepad(1L, 100, null));
        garrotController.save(temp);
        List<Garrot> actual = garrotController.findAll();
        savedID = actual.get(actual.size()-1).getId();

        Garrot temp1 = new Garrot(savedID, 10, 10, new Notepad(1L, 100, null));
        expected.add(temp1);

        actual = garrotController.update(savedID, temp1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void deleteGarrot_true () {
        Garrot temp = new Garrot(6L, 10, 10, new Notepad(1L, 100, null));

        garrotController.save(temp);
        List<Garrot> actual = garrotController.findAll();
        savedID = actual.get(actual.size()-1).getId();
        garrotController.delete(savedID);
        actual = garrotController.findAll();
        savedID = null;
        Assert.assertEquals(expected, actual);
    }

    @After
    public void tearDown () {
        if (savedID!=null)
            garrotController.delete(savedID);
    }
}
