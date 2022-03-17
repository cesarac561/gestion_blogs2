package com.bootcamp.gestion.blogs.services;

import com.bootcamp.gestion.blogs.entities.Post;

import java.util.List;

public interface PostService {

    List<Post> findAll();
    Post findById(Long id);
    Post save(Post post);
    void delete(Long id);
    Post publicarPost(Long id);
}
