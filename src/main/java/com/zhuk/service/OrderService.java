package com.zhuk.service;

import com.zhuk.domain.order.Order;
import com.zhuk.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private OrderRepo orderRepo;

    @Autowired
    public OrderService(@Qualifier("fakeorderdb") OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public void save(Order order) {
        orderRepo.saveOrder(order);
    }

    public List<Order> findAllOrder() {
        return orderRepo.findAllOrder();
    }
}
