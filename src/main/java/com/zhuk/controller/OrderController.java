package com.zhuk.controller;

import com.zhuk.domain.Order;
import com.zhuk.domain.OrderStatus;
import com.zhuk.domain.User;
import com.zhuk.service.OrderService;
import com.zhuk.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("orders")
public class OrderController {

    private OrderService orderService;
    private UserService userService;

    @GetMapping("/status/{s}")
    public List<Order> findAllByStatus(@PathVariable String s) {
        OrderStatus status = OrderStatus.valueOf(s.toUpperCase());
        return orderService.findAllByStatus(status);
    }

    @GetMapping("/user/{id}")
    public List<Order> findAllByMaterial(@PathVariable Long id) {
        User user = userService.findFirstById(id);
        return orderService.findAllByUser(user);
    }

    @GetMapping("/")
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @GetMapping("{id}")
    public Order findById(@PathVariable Long id) {
        return orderService.findFirstById(id);
    }

    @PostMapping
    public List<Order> save(Order order) {
        orderService.save(order);
        return orderService.findAll();
    }

    @PutMapping("{id}")
    public List<Order> update(@PathVariable Long id, @RequestBody Order order) {
        orderService.update(id, order);
        return orderService.findAll();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        orderService.delete(id);
    }

}
