package db;

import com.zhuk.config.Application;
import com.zhuk.controller.GlovesController;
import com.zhuk.domain.Bandage;
import com.zhuk.domain.Gloves;
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

public class GlovesTest {

    AnnotationConfigApplicationContext context;
    GlovesController glovesController;
    List<Gloves> expected = new LinkedList<>();
    Long savedID = null;

    @Before
    public void setUp () {
        context = new AnnotationConfigApplicationContext(Application.class);

        glovesController = context.getBean(GlovesController.class);

        expected = glovesController.findAll();
    }

    @Test
    public void findAllGloves_true () {

        List<Gloves> expected1 = new LinkedList<>();
        expected1.add(new Gloves(1L, Material.LEATHER, null, null));
        expected1.add(new Gloves(2L, Material.RUBBER, null, null));
        expected1.add(new Gloves(3L, Material.RUBBER, null, null));
        expected1.add(new Gloves(4L, Material.RUBBER, null, null));

        List<Gloves> actual = glovesController.findAll();

        Assert.assertEquals(expected1,actual);
    }

    @Test
    public void findGlovesByID_true () {
        Gloves actual = glovesController.findById(2L);

        Assert.assertEquals(expected.get(1), actual);
    }

    @Test(expected = ElementNotFoundException.class)
    public void findGlovesById_false () {
        glovesController.findById(100L);
    }

    @Test
    public void findGlovesByMaterial_true () {
        List<Gloves> actual = glovesController.findAllByMaterial(Material.LEATHER.toString());
        Assert.assertEquals(Collections.singletonList(expected.get(0)) , actual);
    }

    @Test
    public void saveGloves_true () {

        Gloves temp = new Gloves(5L, Material.LEATHER, null, null);
        expected.add(temp);
        glovesController.save(temp);

        List<Gloves> actual = glovesController.findAll();
        savedID = actual.get(actual.size()-1).getId();
        expected.get(expected.size()-1).setId(savedID);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void updateGloves_true () {

        Gloves temp = new Gloves(6L, Material.CLOTH, null, null);
        glovesController.save(temp);
        List<Gloves> actual = glovesController.findAll();
        savedID = actual.get(actual.size()-1).getId();

        Gloves temp1 = new Gloves(savedID, Material.CLOTH, null, null);
        expected.add(temp1);

        actual = glovesController.update(savedID, temp1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void deleteGloves_true () {
        Gloves temp = new Gloves(7L, Material.CLOTH, null, null);

        glovesController.save(temp);
        List<Gloves> actual = glovesController.findAll();
        savedID = actual.get(actual.size()-1).getId();
        glovesController.delete(savedID);
        actual = glovesController.findAll();
        savedID = null;
        Assert.assertEquals(expected, actual);
    }

    @After
    public void tearDown () {
        if (savedID!=null)
            glovesController.delete(savedID);
    }
}
