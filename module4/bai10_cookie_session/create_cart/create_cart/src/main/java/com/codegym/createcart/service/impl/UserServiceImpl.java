package com.codegym.createcart.service.impl;

import com.codegym.createcart.model.User;
import com.codegym.createcart.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public Iterable<User> findAll() {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public void save(User user) {

    }


    @Override
    public void remove(Long id) {

    }
}
