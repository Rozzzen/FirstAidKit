package com.zhuk.repo;

import com.zhuk.domain.order.Order;

import java.util.List;

public interface OrderRepo {
    List<Order> findAllOrder();
    void saveOrder(Order order);
}
