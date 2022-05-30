package com.codegym.createcart.service;

import com.codegym.createcart.model.Order;
import com.codegym.createcart.model.User;

public interface UserService {
    Iterable<User> findAll();

    User findById(Long id);

    void save(User user);

    void remove(Long id);
}
