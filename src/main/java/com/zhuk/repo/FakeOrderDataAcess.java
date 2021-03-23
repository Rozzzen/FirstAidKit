package com.zhuk.repo;

import com.zhuk.domain.order.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("fakeorderdb")
public class FakeOrderDataAcess implements OrderRepo {

    Long counter = 1L;
    private final List<Order> orders = new ArrayList<>();

    @Override
    public List<Order> findAllOrder() {
        return orders;
    }

    @Override
    public void saveOrder(Order order) {
        order.setId(counter++);
        orders.add(order);
    }
}
