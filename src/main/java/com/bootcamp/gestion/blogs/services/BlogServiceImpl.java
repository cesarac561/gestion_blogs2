package com.bootcamp.gestion.blogs.services;

import com.bootcamp.gestion.blogs.entities.Author;
import com.bootcamp.gestion.blogs.entities.Blog;
import com.bootcamp.gestion.blogs.entities.Post;
import com.bootcamp.gestion.blogs.repositories.AuthorRepository;
import com.bootcamp.gestion.blogs.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Blog> findByName(String nombre) {
        return this.blogRepository.find(nombre);
    }

    @Override
    public List<Blog> findAll() {
        return this.blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return this.blogRepository.findById(id).get();
    }

    @Override
    public Blog save(Blog blog) {

        Author author = this.authorRepository.findById(blog.getAuthor().getId()).get();

        //Regla: Solo pueden tener blogs los autores mayores de 18 años.
        if (author.obtenerEdad() < 18) {
            return null;
        }

        if(blog.getId() == null) {
            //Regla: Un autor puede tener máximo 03 blogs.
            //Se está asumiendo que una vez que se inactiva un blog no se puede volver a activar
            //Por lo tanto hacemos la validación de los 3 blogs, solo con blogs activos
            if (author.contarBlogsActivos() == 3) {
                return null;
            }
            blog.setStatus("activo");
        }

        return this.blogRepository.save(blog);
    }

    @Override
    public void delete(Long id) {
        this.blogRepository.deleteById(id);
    }

    @Override
    public Blog inactivarBlog(Long id){
        var blog = this.findById(id);

        blog.setStatus("inactivo");

        return this.blogRepository.save(blog);
    }

}
