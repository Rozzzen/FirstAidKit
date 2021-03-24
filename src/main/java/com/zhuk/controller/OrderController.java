package com.zhuk.controller;

import com.zhuk.domain.order.Order;
import com.zhuk.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public List<Order> OrderList() {
        return orderService.findAllOrder();
    }

    @PostMapping
    public List<Order> save(@RequestBody Order order) {
        orderService.save(order);
        return orderService.findAllOrder();
    }
}
