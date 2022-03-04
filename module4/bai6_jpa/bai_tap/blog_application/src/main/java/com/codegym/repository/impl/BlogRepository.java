package com.codegym.repository.impl;

import com.codegym.model.Blog;
import com.codegym.repository.IBlogRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class BlogRepository implements IBlogRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Blog blog) {
        if (blog.getBlogId() != null){
            entityManager.merge(blog);
        }else {
            entityManager.persist(blog);
        }
    }

    @Override
    public List<Blog> findAll() {
        TypedQuery<Blog> query = entityManager.createQuery("select b from Blog b", Blog.class);
        return query.getResultList();
    }

    @Override
    public Blog findById(Long id) {
        TypedQuery<Blog> query = entityManager.createQuery("select b from Blog  b where b.blogId = :id", Blog.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public void remove(Long id) {
        Blog blog = findById(id);
        if (blog != null){
            entityManager.remove(blog);
        }
    }
}
