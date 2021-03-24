package com.zhuk.repo;

import com.zhuk.domain.order.Order;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("fakeorderdb")
@NoArgsConstructor
public class FakeOrderDataAcess implements OrderRepo {

    private Long counter;
    private List<Order> orders = new ArrayList<>();

    public FakeOrderDataAcess(List<Order> orders) {
        this.orders = orders;
        counter = (long) this.orders.size();
    }

    @Override
    public List<Order> findAllOrder() {
        return orders;
    }

    @Override
    public void saveOrder(Order order) {
        order.setId(++counter);
        orders.add(order);
    }
}
