package com.sushishop.sushishop.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.sushishop.sushishop.entity.Order;
import com.sushishop.sushishop.repository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    public Order getOrderById(int id)
    {
        return null;
    }

    public List<Order> getAllOrders()
    {
        return null;
    }

    @PostMapping
    public void saveOrUpdate(Order order)
    {
        // OrderRepository.save(order); //persist Order entity in database
    }

    public void deleteOrderById(int id)
    {

    }
}
