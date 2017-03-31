package com.polytech.business;

import java.util.List;

/**
 * Created by User on 13/03/2017.
 */
public interface CommentService {
    void comment(Comment comment);

    List<Comment> fetchAll();
}
