import com.zhuk.controller.OrderController;
import com.zhuk.domain.aidkit.FirstAidKit;
import com.zhuk.domain.order.Order;
import com.zhuk.domain.user.User;
import com.zhuk.exception.aidkit.AidKitAlreadyExistsException;
import com.zhuk.exception.user.UserAlreadyExistsException;
import com.zhuk.repo.FakeOrderDataAcess;
import com.zhuk.service.OrderService;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

public class OrderControllerTest {

    private final OrderController orderController;

    public OrderControllerTest() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1L,null, null));
        orders.add(new Order(2L,null, null));
        orders.add(new Order(3L,null, null));
        orders.add(new Order(4L,null, null));
        FakeOrderDataAcess fakeOrderDataAcess = new FakeOrderDataAcess(orders);
        orderController = new OrderController(new OrderService(fakeOrderDataAcess));
    }


    @Test
    public void shouldAddOrderAndSetIdToFive() {
        List<Order> expected = new ArrayList<>();
        expected.add(new Order(1L,null, null));
        expected.add(new Order(2L,null, null));
        expected.add(new Order(3L,null, null));
        expected.add(new Order(4L,null, null));
        expected.add(new Order(5L,null, null));

        List<Order> actual = orderController.save(new Order(5L,null, null));

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnAllOrdersTest() {
        List<Order> expected = new ArrayList<>();
        expected.add(new Order(1L,null, null));
        expected.add(new Order(2L,null, null));
        expected.add(new Order(3L,null, null));
        expected.add(new Order(4L,null, null));

        List<Order> actual = orderController.OrderList();

        Assert.assertEquals(expected, actual);
    }
}
