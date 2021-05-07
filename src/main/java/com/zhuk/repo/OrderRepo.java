package com.zhuk.repo;

import com.zhuk.domain.Order;
import com.zhuk.domain.OrderStatus;
import com.zhuk.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {

    List<Order> findAllByStatus(OrderStatus orderStatus);

    List<Order> findAllByUser(User user);
}
