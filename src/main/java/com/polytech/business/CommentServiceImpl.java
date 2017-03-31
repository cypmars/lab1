package com.polytech.business;

import com.polytech.repository.CommentRepository;
import com.polytech.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by User on 13/03/2017.
 */
@Component
public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void comment(Comment comment){
        commentRepository.save(comment);
    }

    public List<Comment> fetchAll(){
        return commentRepository.findAll();
    }
}
