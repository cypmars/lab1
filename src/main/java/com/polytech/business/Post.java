package com.polytech.business;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

/**
 * Created by User on 13/03/2017.
 */
@Entity
@Table(name="POST")
public class Post {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="CONTENT")
    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    public Post(String content) {
        this.content = content;
    }

    public Post() {
    }

    @Override
    public String toString() {
        return "Post{" +
                "content='" + content + '\'' +
                '}';
    }

    public String getContent() {
        return content;
    }
}
