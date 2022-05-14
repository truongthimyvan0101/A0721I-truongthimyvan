package com.codegym.service;

import com.codegym.model.Blog;

import java.util.List;

public interface IBlogService {
    void save(Blog blog);

    List<Blog> findAll();

    Blog findById(Long id);

    void remove(Long id);
}
