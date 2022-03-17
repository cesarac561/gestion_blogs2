package com.bootcamp.gestion.blogs.repositories;

import com.bootcamp.gestion.blogs.entities.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    @Query("SELECT p FROM Blog p WHERE UPPER(name) LIKE CONCAT('%',UPPER(:#{#nombre}),'%')  ")
    List<Blog> find(String nombre);
}
