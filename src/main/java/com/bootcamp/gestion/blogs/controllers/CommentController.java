package com.bootcamp.gestion.blogs.controllers;

import com.bootcamp.gestion.blogs.entities.Blog;
import com.bootcamp.gestion.blogs.entities.Comment;
import com.bootcamp.gestion.blogs.entities.Post;
import com.bootcamp.gestion.blogs.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public List<Comment> findAll(){
        System.out.println("call findALl");
        return this.commentService.findAll();
    }

    @GetMapping("/{id}")
    public Comment findById(@PathVariable("id") Long id){
        System.out.println("id = " + id);
        return this.commentService.findById(id);
    }

    @GetMapping("/buscar")
    public List<Comment> findByName(@RequestParam("nombre") String nombre){
        return this.commentService.findByName(nombre);
    }

    @PostMapping
    public Comment save(@RequestBody Comment comment){
        Comment commentInUpd = this.commentService.save(comment);
        if(commentInUpd == null)
            System.out.println("No puede crear/actualizar comentario");
        return commentInUpd;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        this.commentService.delete(id);
    }

    @PatchMapping("/{id}/publicar-comment")
    public Comment publicarComment(@PathVariable("id") Long id){
        return this.commentService.publicarComment(id);
    }


}
