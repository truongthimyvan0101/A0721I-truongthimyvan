package com.codegym.blog_application3.Repository;


import com.codegym.blog_application3.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog,Long> {
    @Override
    List<Blog> findAll();
}

