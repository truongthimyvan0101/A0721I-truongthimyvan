package com.codegym.blog_application3.service;

import com.codegym.blog_application3.model.Blog;
import com.codegym.blog_application3.service.impl.BlogServiceImpl;

import java.util.List;

public interface BlogService {
    List<BlogServiceImpl> findAll();

    Blog findById(int id);

    void save(Blog blog);

    void remove(int id);

    List<Blog> findByTitle(String title);
}
