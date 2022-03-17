package com.bootcamp.gestion.blogs.services;

import com.bootcamp.gestion.blogs.entities.Author;
import com.bootcamp.gestion.blogs.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> findByName(String nombre) {
        return this.authorRepository.find(nombre);
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Author findById(Long id) {
        return this.authorRepository.findById(id).get();
    }

    @Override
    public Author save(Author author) {
        return this.authorRepository.save(author);
    }

    @Override
    public void delete(Long id) {
        this.authorRepository.deleteById(id);
    }
}
