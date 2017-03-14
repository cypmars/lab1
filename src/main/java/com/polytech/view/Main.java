package com.polytech.view;

import com.polytech.business.Post;
import com.polytech.business.PublicationService;
import com.polytech.business.PublicationServiceImpl;
import com.polytech.config.ApplicationConfig;
import com.polytech.repository.PostRepository;
import com.polytech.repository.PostRepositoryImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Created by User on 13/03/2017.
 */
public class Main {
    public static void main(String[] args) {
        PostRepository postRepository = new PostRepositoryImpl();
        PublicationService publicationService = new PublicationServiceImpl(postRepository);

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        applicationContext.getBean(PublicationService.class);

        Post post = new Post("Bonjor");
        publicationService.post(post);

        List<Post> postList = publicationService.fetchAll();
        System.out.println(postList);

    }
}
