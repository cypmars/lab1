package com.polytech.config;

import com.polytech.business.PublicationService;
import com.polytech.business.PublicationServiceImpl;
import com.polytech.repository.PostRepository;
import com.polytech.repository.PostRepositoryImpl;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * Created by User on 13/03/2017.
 */
@Configuration
public class ApplicationConfig {

   // @Bean
   // public DataSource dataSource() {
    //    return (new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("create-schema.sql").build());
   // }

    @Value("${datasource.driverName}")
    private String driverClassName;

    @Value("${datasource.url}")
    private String url;

    @Value("${datasource.username}")
    private String username;

    @Value("${datasource.password}")
    private String password;

    @Bean
    public DataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("driverName");
        dataSource.setUrl("url");
        dataSource.setUsername("username");
        dataSource.setPassword("password");
        return dataSource;
    }
    @Bean
    public PostRepository postRepository(){
        return new PostRepositoryImpl(dataSource());
    }

    @Bean
    public PublicationService publicationService(PostRepository postRepository) {
        return new PublicationServiceImpl(postRepository);
    }
}
