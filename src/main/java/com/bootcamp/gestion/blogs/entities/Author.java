package com.bootcamp.gestion.blogs.entities;

import javax.persistence.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="author")
public class Author {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(unique = true , nullable = false)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private Date birthdate;

    //Regla: Al eliminar un autor, debe realizarse una eliminación en cadena de sus blogs, post y comentarios.
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    private List<Blog> blogs;

    public Author() {
    }

    public Author(String name, String email, String phone, Date birthdate) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthdate = birthdate;
        this.blogs = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public int obtenerEdad(){
        return Period.between(this.birthdate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now()).getYears();
    }

    public int contarBlogsActivos(){
        int contador = 0;

        for(Blog blogDeAuthor : this.getBlogs()){
            if(blogDeAuthor.getStatus().equals("activo")){
                contador++;
            }
        }

        return contador;
    }

    public void añadirBlog(Blog blog){
        this.blogs.add(blog);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", birthdate=" + birthdate +
                ", blogs=" + blogs +
                '}';
    }

}
