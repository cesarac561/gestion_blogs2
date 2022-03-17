package com.bootcamp.gestion.blogs.services;

import com.bootcamp.gestion.blogs.entities.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findByName(String nombre);
    List<Comment> findAll();
    Comment findById(Long id);
    Comment save(Comment comment);
    void delete(Long id);
    Comment publicarComment(Long id);
}
