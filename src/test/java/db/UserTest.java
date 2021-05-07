package db;

import com.zhuk.config.Application;
import com.zhuk.controller.BandageController;
import com.zhuk.controller.UserController;
import com.zhuk.domain.Bandage;
import com.zhuk.domain.Material;
import com.zhuk.domain.Role;
import com.zhuk.domain.User;
import com.zhuk.exception.ElementNotFoundException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class UserTest {

    AnnotationConfigApplicationContext context;
    UserController userController;
    List<User> expected = new LinkedList<>();
    Long savedID = null;

    @Before
    public void setUp () {
        context = new AnnotationConfigApplicationContext(Application.class);

        userController = context.getBean(UserController.class);

        expected = userController.findAll();
    }

    @Test
    public void findAllUsers_true () {

        List<User> expected1 = new LinkedList<>();
        expected1.add(new User(1L, "Sebastian", "Fors", "user1@gmail.com", "qwe", "qwe", new Role(1L, "Admin"), null));
        expected1.add(new User(2L, "Mike", "Johnes", "user2@gmail.com", "qwe", "qwe", new Role(2L, "User"), null));
        expected1.add(new User(3L, "Andrew", "Smith", "user3@gmail.com", "qwe", "qwe", new Role(1L, "Admin"), null));
        expected1.add(new User(4L, "Andrew", "Ramirez", "user4@gmail.com", "qwe", "qwe", new Role(1L, "Admin"), null));
        expected1.add(new User(5L, "Andrew", "Nice", "user5@gmail.com", "qwe", "qwe", new Role(1L, "Admin"), null));

        List<User> actual = userController.findAll();

        Assert.assertEquals(expected1,actual);
    }

    @Test
    public void findUserByID_true () {
        User actual = userController.findById(2L);

        Assert.assertEquals(expected.get(1), actual);
    }

    @Test(expected = ElementNotFoundException.class)
    public void findUserById_false () {
        userController.findById(100L);
    }

    @Test
    public void saveUser_true () {

        User temp = new User(6L, "Andrew", "Smith", "user6@gmail.com", "qwe", "qwe", new Role(1L, "Admin"), null);
        expected.add(temp);
        userController.save(temp);

        List<User> actual = userController.findAll();
        savedID = actual.get(actual.size()-1).getId();
        expected.get(expected.size()-1).setId(savedID);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void updateUser_true () {

        User temp = new User(7L, "Andrew", "Smith", "user7@gmail.com", "qwe", "qwe", new Role(1L, "Admin"), null);
        userController.save(temp);
        List<User> actual = userController.findAll();
        savedID = actual.get(actual.size()-1).getId();

        User temp1 = new User(savedID, "Andrew", "Smith", "user6@gmail.com", "qwe", "qwe", new Role(1L, "Admin"), null);
        expected.add(temp1);

        actual = userController.update(savedID, temp1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void deleteUser_true () {
        User temp = new User(8L, "Andrew", "Smith", "user8@gmail.com", "qwe", "qwe", new Role(1L, "Admin"), null);

        userController.save(temp);
        List<User> actual = userController.findAll();
        savedID = actual.get(actual.size()-1).getId();
        userController.delete(savedID);
        actual = userController.findAll();
        savedID = null;
        Assert.assertEquals(expected, actual);
    }

    @After
    public void tearDown () {
        if (savedID!=null)
            userController.delete(savedID);
    }
}
