package com.bootcamp.gestion.blogs.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="post")
public class Post {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(unique = true , nullable = false)
    private Long id;
    private String title;
    private Date date;
    private String status;
    private String content;
    @ManyToOne()
    @JoinColumn(name = "blog_id", nullable = false, updatable = false)
    @JsonIgnoreProperties(value="posts")
    private Blog blog;

    //Regla: Al eliminar un autor, debe realizarse una eliminación en cadena de sus blogs, post y comentarios.
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<Comment> comments;

    public Post(){

    }

    public Post(String title, Date date, String status, String content, Blog blog) {
        this.title = title;
        this.date = date;
        this.status = status;
        this.content = content;
        this.blog = blog;
        this.comments = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void añadirComments(Comment comment){
        this.comments.add(comment);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", content='" + content + '\'' +
                ", blog=" + blog +
                ", comments=" + comments +
                '}';
    }
}
