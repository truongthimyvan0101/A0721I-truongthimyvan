package com.codegym.createcart.service;

import com.codegym.createcart.model.Order;

public interface OrderService {
    Iterable<Order> findAll();

    Order findById(Long id);

    void save(Order order);

    void remove(Long id);
}
