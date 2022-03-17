package com.bootcamp.gestion.blogs.controllers;

import com.bootcamp.gestion.blogs.entities.Author;
import com.bootcamp.gestion.blogs.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("autores")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<Author> findAll(){
        System.out.println("call findALl");
        return this.authorService.findAll();
    }

    @GetMapping("/{id}")
    public Author findById(@PathVariable("id") Long id){
        System.out.println("id = " + id);
        return this.authorService.findById(id);
    }

    @GetMapping("/buscar")
    public List<Author> findByName(@RequestParam("nombre") String nombre){
        return this.authorService.findByName(nombre);
    }

    @PostMapping
    public Author save(@RequestBody Author author){
        return this.authorService.save(author);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        this.authorService.delete(id);
    }


}
