package com.polytech.repository;

import com.polytech.business.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by User on 13/03/2017.
 */
public interface PostRepository extends JpaRepository<Post,Long> {

}
