package com.bootcamp.gestion.blogs.services;

import com.bootcamp.gestion.blogs.entities.Blog;
import com.bootcamp.gestion.blogs.entities.Comment;
import com.bootcamp.gestion.blogs.entities.Post;
import com.bootcamp.gestion.blogs.repositories.CommentRepository;
import com.bootcamp.gestion.blogs.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Comment> findByName(String nombre) {
        return this.commentRepository.find(nombre);
    }

    @Override
    public List<Comment> findAll() {
        return this.commentRepository.findAll();
    }

    @Override
    public Comment findById(Long id) {
        return this.commentRepository.findById(id).get();
    }

    @Override
    public Comment save(Comment comment) {

        Post post = this.postRepository.findById(comment.getPost().getId()).get();

        //Regla: Solo se pueden registrar comentarios en post en estado publicado.
        if(!post.getStatus().equals("publicado"))
            return null;

        if (comment.getId() == null) {
            comment.setEstado("borrador");
        }
        return this.commentRepository.save(comment);

    }

    @Override
    public void delete(Long id) {
        this.commentRepository.deleteById(id);
    }

    @Override
    public Comment publicarComment(Long id){
        var comment = this.findById(id);

        comment.setEstado("publicado");
        return this.commentRepository.save(comment);
    }


}
