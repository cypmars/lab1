package com.polytech.business;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.Mapping;

import javax.persistence.*;
import java.util.*;

/**
 * Created by User on 13/03/2017.
 */
@Entity
@Table(name="POST")
public class Post implements java.io.Serializable{

    @Id
    @Column(name="POST_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="CONTENT")
    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    public Post() {
    }

    public Post(String content) {
        this.content = content;
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
