package db;

import com.zhuk.config.Application;
import com.zhuk.controller.BandageController;
import com.zhuk.controller.NotepadController;
import com.zhuk.domain.Bandage;
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

public class NotepadTest {

    AnnotationConfigApplicationContext context;
    NotepadController notepadController;
    List<Notepad> expected = new LinkedList<>();
    Long savedID = null;

    @Before
    public void setUp () {
        context = new AnnotationConfigApplicationContext(Application.class);

        notepadController = context.getBean(NotepadController.class);

        expected = notepadController.findAll();
    }

    @Test
    public void findAllNotepads_true () {

        List<Notepad> expected1 = new LinkedList<>();
        expected1.add(new Notepad(1L, 100, null));
        expected1.add(new Notepad(2L, 200, null));
        expected1.add(new Notepad(3L, 300, null));
        expected1.add(new Notepad(4L, 400, null));
        expected1.add(new Notepad(5L, 500, null));

        List<Notepad> actual = notepadController.findAll();

        Assert.assertEquals(expected1,actual);
    }

    @Test
    public void findNotepadByID_true () {
        Notepad actual = notepadController.findById(2L);

        Assert.assertEquals(expected.get(1), actual);
    }

    @Test(expected = ElementNotFoundException.class)
    public void findNotepadById_false () {
        notepadController.findById(100L);
    }

    @After
    public void tearDown () {
        if (savedID!=null)
            notepadController.delete(savedID);
    }
}
