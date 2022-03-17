package com.bootcamp.gestion.blogs.services;

import com.bootcamp.gestion.blogs.entities.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findByName(String nombre);
    List<Author> findAll();
    Author findById(Long id);
    Author save(Author author);
    void delete(Long id);
}
