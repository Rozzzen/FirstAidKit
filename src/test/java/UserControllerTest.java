//import com.zhuk.controller.UserController;
//import com.zhuk.domain.User;
//import com.zhuk.exception.user.UserAlreadyExistsException;
//import com.zhuk.exception.user.UserNotFoundException;
//import com.zhuk.repo.FakeUserDataAcess;
//import com.zhuk.service.UserService;
//import org.junit.Assert;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.rules.ExpectedException;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserControllerTest {
//
//    private final UserController userController;
//
//    public UserControllerTest() {
//        List<User> users = new ArrayList<>();
//        users.add(new User(1L, "John", null, null, null, null, null, null, null));
//        users.add(new User(2L, "Mark", null, null, null, null, null, null, null));
//        users.add(new User(3L, "Steve", null, null, null, null, null, null, null));
//        users.add(new User(4L, "Jake", null, null, null, null, null, null, null));
//        FakeUserDataAcess fakeUserDataAcess = new FakeUserDataAcess(users);
//        userController = new UserController(new UserService(fakeUserDataAcess));
//    }
//
//    @Test
//    public void shouldReturnAllUsersTest() {
//        List<User> expected = new ArrayList<>();
//        expected.add(new User(1L, "John", null, null, null, null, null, null, null));
//        expected.add(new User(2L, "Mark", null, null, null, null, null, null, null));
//        expected.add(new User(3L, "Steve", null, null, null, null, null, null, null));
//        expected.add(new User(4L, "Jake", null, null, null, null, null, null, null));
//
//        List<User> actual = userController.UserList();
//
//        Assert.assertEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldReturnUserWithIdOne() throws UserNotFoundException {
//        User expected = new User(1L, "John", null, null, null, null, null, null, null);
//
//        User actual = userController.UserById(1L);
//
//        Assert.assertEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldEditExistingUserWithIdTwo() {
//        List<User> expected = new ArrayList<>();
//
//        User updateUser = new User(2L, "UpdatedMark", null, null, null, null, null, null, null);
//
//        expected.add(new User(1L, "John", null, null, null, null, null, null, null));
//        expected.add(updateUser);
//        expected.add(new User(3L, "Steve", null, null, null, null, null, null, null));
//        expected.add(new User(4L, "Jake", null, null, null, null, null, null, null));
//
//        List<User> actual = userController.updateUser(2L, updateUser);
//
//        Assert.assertEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldCreateNewUserWithIdFive() {
//        List<User> expected = new ArrayList<>();
//
//        User updateUser = new User(5L, "UpdatedMark", null, null, null, null, null, null, null);
//
//        expected.add(new User(1L, "John", null, null, null, null, null, null, null));
//        expected.add(new User(2L, "Mark", null, null, null, null, null, null, null));
//        expected.add(new User(3L, "Steve", null, null, null, null, null, null, null));
//        expected.add(new User(4L, "Jake", null, null, null, null, null, null, null));
//        expected.add(updateUser);
//
//        List<User> actual = userController.updateUser(5L, updateUser);
//
//        Assert.assertEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldDeleteUserWithIdOne() {
//        List<User> expected = new ArrayList<>();
//        expected.add(new User(2L, "Mark", null, null, null, null, null, null, null));
//        expected.add(new User(3L, "Steve", null, null, null, null, null, null, null));
//        expected.add(new User(4L, "Jake", null, null, null, null, null, null, null));
//
//        List<User> actual = userController.deleteUser(1L);
//
//        Assert.assertEquals(expected, actual);
//    }
//
//    @Rule
//    public final ExpectedException expectedException = ExpectedException.none();
//
//
//    @Test
//    public void shouldAddUserAndSetIdToFive() throws UserAlreadyExistsException {
//        List<User> expected = new ArrayList<>();
//        expected.add(new User(1L, "John", null, null, null, null, null, null, null));
//        expected.add(new User(2L, "Mark", null, null, null, null, null, null, null));
//        expected.add(new User(3L, "Steve", null, null, null, null, null, null, null));
//        expected.add(new User(4L, "Jake", null, null, null, null, null, null, null));
//        expected.add(new User(5L, "Paul", null, null, null, null, null, null, null));
//
//        List<User> actual = userController.saveUser(
//                new User(5L, "Paul", null, null, null, null, null, null, null)
//        );
//
//        Assert.assertEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldThrowAlreadyExistingException() throws UserAlreadyExistsException {
//        expectedException.expect(UserAlreadyExistsException.class);
//        List<User> temp = userController.saveUser(
//                new User(4L, "Jake", null, null, null, null, null, null, null)
//        );
//    }
//}
