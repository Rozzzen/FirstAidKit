package com.zhuk.controller;

import com.zhuk.domain.aidkit.FirstAidKit;
import com.zhuk.domain.order.Order;
import com.zhuk.domain.user.User;
import com.zhuk.exception.user.UserAlreadyExistsException;
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
    public List<Order> saveUser(@RequestBody Order order) throws UserAlreadyExistsException {
        if(orderService.findAllOrder().contains(order)) {
            throw new UserAlreadyExistsException("This user already exists");
        }
        else {
            orderService.save(order);
            return orderService.findAllOrder();
        }
    }
}
