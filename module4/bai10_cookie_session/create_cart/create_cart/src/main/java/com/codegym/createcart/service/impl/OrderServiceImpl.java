package com.codegym.createcart.service.impl;

import com.codegym.createcart.model.Order;
import com.codegym.createcart.repository.OrderRepository;
import com.codegym.createcart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Override
    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }


    @Override
    public void remove(Long id) {
orderRepository.findById(id);
    }
}
