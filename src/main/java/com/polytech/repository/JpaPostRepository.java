package com.polytech.repository;

import com.polytech.business.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 13/03/2017.
 */
@Component
@Transactional
public class JpaPostRepository implements PostRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public JpaPostRepository(){


    }
    public List<Post> findAll() {
        String qlString = "SELECT p FROM Post p";
        Query query = entityManager.createQuery(qlString);
        return query.getResultList();
    }

    public void save(Post post) {
        entityManager.persist(post);
    }

}
