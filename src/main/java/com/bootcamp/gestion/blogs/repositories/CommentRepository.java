package com.bootcamp.gestion.blogs.repositories;

import com.bootcamp.gestion.blogs.entities.Blog;
import com.bootcamp.gestion.blogs.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("SELECT p FROM Comment p WHERE UPPER(name) LIKE CONCAT('%',UPPER(:#{#nombre}),'%')  ")
    List<Comment> find(String nombre);
}
