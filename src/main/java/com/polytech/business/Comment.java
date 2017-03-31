package com.polytech.business;

import javax.persistence.*;

/**
 * Created by User on 31/03/2017.
 */
@Entity
@Table(name="COMMENT")
public class Comment implements java.io.Serializable{
    @Id
    @Column(name="COMMENT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="CONTENT")
    private String content;

    private Post post;

    public void setContent(String content) {
        this.content = content;
    }

    public Comment(String content, Post post) {
        this.content = content;
        this.post = post;
    }

    public Comment() {
    }

    @Override
    public String toString() {
        return "Comment{" +
                "content='" + content + '\'' +
                '}';
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POST_ID", nullable = false)
    public Post getPost() {
        return this.post;
    }

    public String getContent() {
        return content;
    }
}
