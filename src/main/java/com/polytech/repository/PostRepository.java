package com.polytech.repository;

import com.polytech.business.Post;

import java.util.List;

/**
 * Created by User on 13/03/2017.
 */
public interface PostRepository{
    void save(Post post);

    Post findById(long id);

    List<Post> findAll();
}
