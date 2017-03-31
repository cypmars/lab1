package com.polytech.repository;

import com.polytech.business.Comment;
import com.polytech.business.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by User on 13/03/2017.
 */
public interface CommentRepository extends JpaRepository<Comment,Long> {

}
