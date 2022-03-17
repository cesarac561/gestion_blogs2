package com.bootcamp.gestion.blogs.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(unique = true , nullable = false)
    private Long id;
    private Date date;
    private String name;
    private String estado;
    private String comment;
    @ManyToOne()
    @JoinColumn(name = "post_id", nullable = false, updatable = false)
    @JsonIgnoreProperties(value="comments")
    private Post post;

    public Comment(){

    }

    public Comment(Date date, String name, String estado, String comment, Post post) {
        this.date = date;
        this.name = name;
        this.estado = estado;
        this.comment = comment;
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", date=" + date +
                ", name='" + name + '\'' +
                ", estado='" + estado + '\'' +
                ", comment='" + comment + '\'' +
                ", post=" + post +
                '}';
    }
}
