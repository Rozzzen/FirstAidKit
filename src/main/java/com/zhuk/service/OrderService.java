package com.zhuk.service;

import com.zhuk.domain.Order;
import com.zhuk.domain.OrderStatus;
import com.zhuk.domain.User;
import com.zhuk.exception.ElementNotFoundException;
import com.zhuk.repo.OrderRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private OrderRepo orderRepo;

    public Order findFirstById(Long id) {
        return orderRepo.findById(id).orElseThrow(ElementNotFoundException::new);
    }

    public List<Order> findAll() {
        return orderRepo.findAll();
    }

    public List<Order> findAllByStatus(OrderStatus orderStatus) {
        return orderRepo.findAllByStatus(orderStatus);
    }

    public List<Order> findAllByUser(User user) {
        return orderRepo.findAllByUser(user);
    }

    public void save(Order order) {
        orderRepo.save(order);
    }

    public void update(Long id, Order order) {
        orderRepo.findById(id).orElseThrow(ElementNotFoundException::new);
        order.setId(id);
        orderRepo.save(order);
    }

    public void delete(Long id) {
        orderRepo.findById(id).orElseThrow(ElementNotFoundException::new);
        orderRepo.deleteById(id);
    }
}
