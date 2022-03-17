package com.bootcamp.gestion.blogs.controllers;

import com.bootcamp.gestion.blogs.entities.Blog;
import com.bootcamp.gestion.blogs.entities.Post;
import com.bootcamp.gestion.blogs.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<Post> findAll(){
        System.out.println("call findALl");
        return this.postService.findAll();
    }

    @GetMapping("/{id}")
    public Post findById(@PathVariable("id") Long id){
        System.out.println("id = " + id);
        return this.postService.findById(id);
    }

    @PostMapping
    public Post save(@RequestBody Post post){
        Post postInUpd = this.postService.save(post);
        if(postInUpd == null)
            System.out.println("No puede crear/actualizar post");
        return postInUpd;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        this.postService.delete(id);
    }

    @PatchMapping("/{id}/publicar-post")
    public Post publicarPost(@PathVariable("id") Long id){
        Post postPub = this.postService.publicarPost(id);
        if(postPub == null)
            System.out.println("No puede publicar post");
        return postPub;
    }

}
