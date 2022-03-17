package com.bootcamp.gestion.blogs.controllers;

import com.bootcamp.gestion.blogs.entities.Blog;
import com.bootcamp.gestion.blogs.entities.Post;
import com.bootcamp.gestion.blogs.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping
    public List<Blog> findAll(){
        System.out.println("call findALl");
        return this.blogService.findAll();
    }

    @GetMapping("/{id}")
    public Blog findById(@PathVariable("id") Long id){
        System.out.println("id = " + id);
        return this.blogService.findById(id);
    }

    @GetMapping("/buscar")
    public List<Blog> findByName(@RequestParam("nombre") String nombre){
        return this.blogService.findByName(nombre);
    }

    @PostMapping
    public Blog save(@RequestBody Blog blog){
        Blog blogInUpd = this.blogService.save(blog);
        if(blogInUpd == null)
            System.out.println("No puede crear/actualizar blog");
        return blogInUpd;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        this.blogService.delete(id);
    }

    @PatchMapping("/{id}/inactivar-blog")
    public Blog inactivarBlog(@PathVariable("id") Long id){
        return this.blogService.inactivarBlog(id);
    }

}
