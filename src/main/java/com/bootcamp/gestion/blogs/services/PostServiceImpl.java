package com.bootcamp.gestion.blogs.services;

import com.bootcamp.gestion.blogs.entities.Author;
import com.bootcamp.gestion.blogs.entities.Blog;
import com.bootcamp.gestion.blogs.entities.Post;
import com.bootcamp.gestion.blogs.repositories.BlogRepository;
import com.bootcamp.gestion.blogs.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<Post> findAll() {
        return this.postRepository.findAll();
    }

    @Override
    public Post findById(Long id) {
        return this.postRepository.findById(id).get();
    }

    @Override
    public Post save(Post post) {
        Blog blog = this.blogRepository.findById(post.getBlog().getId()).get();

        //Solo se puede registrar posts en blogs en estado activo.
        if(!blog.getStatus().equals("activo"))
            return null;

        if (post.getId() == null) {
            post.setStatus("borrador");
        }
        return this.postRepository.save(post);
    }

    @Override
    public void delete(Long id) {
        this.postRepository.deleteById(id);
    }

    @Override
    public Post publicarPost(Long id){
        var post = this.findById(id);
        Blog blog = this.blogRepository.findById(post.getBlog().getId()).get();

        Date fechaHoy = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());

        //Regla: Solo se puede publicar un post por día.
        if(!blog.tienePostsPublicadosHoy(fechaHoy)){
            post.setStatus("publicado");
            post.setDate(fechaHoy);
            return this.postRepository.save(post);
        }
        else
            return null;
    }

}
