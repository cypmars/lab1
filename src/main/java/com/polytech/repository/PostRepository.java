package com.polytech.repository;

import com.polytech.business.Post;

import java.util.List;

/**
 * Created by User on 13/03/2017.
 */
public interface PostRepository {
    List<Post> findAll();

    void save(Post post);
}
