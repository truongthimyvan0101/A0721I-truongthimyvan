package com.codegym.blog_application3.service.impl;

import com.codegym.blog_application3.model.Blog;
import com.codegym.blog_application3.service.BlogService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogServiceImpl implements BlogService {

    @Override
    public List<BlogServiceImpl> findAll() {
        return null;
    }

    @Override
    public Blog findById(int id) {
        return null;
    }

    @Override
    public void save(Blog blog) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Blog> findByTitle(String title) {
        return null;
    }
}
