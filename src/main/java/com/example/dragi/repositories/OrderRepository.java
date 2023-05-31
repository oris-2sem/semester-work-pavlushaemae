package com.example.dragi.repositories;

import com.example.dragi.models.Order;
import com.example.dragi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> getAllByUser(User user);
}
