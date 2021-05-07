package db;

import com.zhuk.config.Application;
import com.zhuk.controller.BandageController;
import com.zhuk.controller.FirstAidKitController;
import com.zhuk.domain.*;
import com.zhuk.exception.ElementNotFoundException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FirstAidKitTest {

    AnnotationConfigApplicationContext context;
    FirstAidKitController firstAidKitController;
    List<FirstAidKit> expected = new LinkedList<>();
    Long savedID = null;

    @Before
    public void setUp () {
        context = new AnnotationConfigApplicationContext(Application.class);

        firstAidKitController = context.getBean(FirstAidKitController.class);

        expected = firstAidKitController.findAll();
    }

    @Test
    public void findAllFirstAidKits_true () {

        List<FirstAidKit> expected1 = new LinkedList<>();
        expected1.add(new FirstAidKit(1L,
                new Bandage(1L, 10, 10, Material.LEATHER, null),
                new Notepad(1L, 100, null),
                new Gloves(1L, Material.LEATHER, null, null),
                new Garrot(1L, 10, 10, new Notepad(1L, 100, null)),
                null
        ));
        expected1.add(new FirstAidKit(2L,
                new Bandage(2L, 20, 20, Material.CLOTH, null),
                new Notepad(2L, 200, null),
                new Gloves(2L, Material.RUBBER, null, null),
                new Garrot(2L, 20, 20, new Notepad(2L, 200, null)),
                null
        ));
        expected1.add(new FirstAidKit(3L,
                new Bandage(3L, 30, 30, Material.CLOTH, null),
                new Notepad(3L, 300, null),
                new Gloves(3L, Material.RUBBER, null, null),
                new Garrot(3L, 30, 30, new Notepad(3L, 300, null)),
                null
        ));
        List<FirstAidKit> actual = firstAidKitController.findAll();

        Assert.assertEquals(expected1,actual);
    }

    @Test
    public void findFirstAidKitByID_true () {
        FirstAidKit actual = firstAidKitController.findById(2L);

        Assert.assertEquals(expected.get(1), actual);
    }

    @Test(expected = ElementNotFoundException.class)
    public void findBandageById_false () {
        firstAidKitController.findById(100L);
    }

    @Test
    public void saveFirstAidKit_true () {

        FirstAidKit temp = new FirstAidKit(4L,
                new Bandage(4L, 40, 40, Material.CLOTH, null),
                new Notepad(6L, 600, null),
                new Gloves(5L, Material.LEATHER, null, null),
                new Garrot(4L, 40, 40, new Notepad(6L, 600, null)),
                null
        );
        expected.add(temp);
        firstAidKitController.save(temp);

        List<FirstAidKit> actual = firstAidKitController.findAll();
        savedID = actual.get(actual.size()-1).getId();
        expected.get(expected.size()-1).setId(savedID);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void updateFirstAidKit_true () {

        FirstAidKit temp = new FirstAidKit(5L,
                new Bandage(5L, 50, 50, Material.CLOTH, null),
                new Notepad(7L, 700, null),
                new Gloves(6L, Material.LEATHER, null, null),
                new Garrot(5L, 50, 50, new Notepad(7L, 700, null)),
                null
        );
        firstAidKitController.save(temp);
        List<FirstAidKit> actual = firstAidKitController.findAll();
        savedID = actual.get(actual.size()-1).getId();

        FirstAidKit temp1 = new FirstAidKit(savedID,
                new Bandage(6L, 60, 60, Material.CLOTH, null),
                new Notepad(8L, 800, null),
                new Gloves(7L, Material.LEATHER, null, null),
                new Garrot(6L, 60, 60, new Notepad(8L, 800, null)),
                null
        );
        expected.add(temp1);

        actual = firstAidKitController.update(savedID, temp1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void deleteFirstAidKit_true () {

        FirstAidKit temp = new FirstAidKit(savedID,
                new Bandage(7L, 70, 70, Material.CLOTH, null),
                new Notepad(9L, 900, null),
                new Gloves(8L, Material.LEATHER, null, null),
                new Garrot(7L, 70, 70, new Notepad(9L, 900, null)),
                null
        );

        firstAidKitController.save(temp);
        List<FirstAidKit> actual = firstAidKitController.findAll();
        savedID = actual.get(actual.size()-1).getId();
        firstAidKitController.delete(savedID);
        actual = firstAidKitController.findAll();
        savedID = null;
        Assert.assertEquals(expected, actual);
    }
    @After
    public void tearDown () {
        if (savedID!=null)
            firstAidKitController.delete(savedID);
    }
}
