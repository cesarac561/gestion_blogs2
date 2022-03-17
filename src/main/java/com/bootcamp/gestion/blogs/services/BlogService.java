package com.bootcamp.gestion.blogs.services;

import com.bootcamp.gestion.blogs.entities.Blog;
import com.bootcamp.gestion.blogs.entities.Post;

import java.util.List;

public interface BlogService {
    List<Blog> findByName(String nombre);
    List<Blog> findAll();
    Blog findById(Long id);
    Blog save(Blog blog);
    void delete(Long id);
    Blog inactivarBlog(Long id);
}
