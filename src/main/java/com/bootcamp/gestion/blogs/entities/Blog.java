package com.bootcamp.gestion.blogs.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(unique = true , nullable = false)
    private Long id;
    private String name;
    private String description;
    private String url;
    private String status;
    @ManyToOne()
    @JoinColumn(name = "author_id", nullable = false, updatable = false)
    @JsonIgnoreProperties(value="blogs")
    private Author author;

    //Regla: Al eliminar un autor, debe realizarse una eliminación en cadena de sus blogs, post y comentarios.
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "blog")
    private List<Post> posts;

    public Blog(){

    }

    public Blog(String name, String description, String url, String status, Author author) {
        this.name = name;
        this.description = description;
        this.url = url;
        this.status = status;
        this.author = author;
        this.posts = new ArrayList<>();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void añadirPost(Post post){
        this.posts.add(post);
    }

    public boolean tienePostsPublicadosHoy(Date fechaHoy){
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
        String sFechaHoy = dt.format(fechaHoy);
        Date fechaPost;
        String sFechaPost;
        boolean resultado = false;

        for(Post postDeBlog : this.getPosts()){
            if(postDeBlog.getStatus().equals("publicado")){
                fechaPost = postDeBlog.getDate();
                sFechaPost = dt.format(fechaPost);
                if(sFechaPost.equals(sFechaHoy)){
                    resultado = true;
                    break;
                }
            }
        }

        return resultado;

    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", status='" + status + '\'' +
                ", author=" + author +
                ", posts=" + posts +
                '}';
    }
}
