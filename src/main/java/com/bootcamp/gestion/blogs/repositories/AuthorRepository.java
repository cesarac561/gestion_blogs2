package com.bootcamp.gestion.blogs.repositories;

import com.bootcamp.gestion.blogs.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("SELECT p FROM Author p WHERE UPPER(name) LIKE CONCAT('%',UPPER(:#{#nombre}),'%')  ")
    List<Author> find(String nombre);
}
