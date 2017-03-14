package com.polytech.repository;

import com.polytech.business.Post;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 13/03/2017.
 */
public class PostRepositoryImpl implements PostRepository {
    List<Post> db = new ArrayList<Post>();
    public List<Post> findAll() {
        return db;
    }
    public void save(Post post) {
        this.db.add(post);
    }

}
