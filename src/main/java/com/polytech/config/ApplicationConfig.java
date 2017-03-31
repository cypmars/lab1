package com.polytech.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * Created by User on 13/03/2017.
 */
@PropertySource("classpath:/application.properties")
@Configuration
@EnableJpaRepositories("com.polytech.repository")
@ComponentScan(basePackages = {"com.polytech.business","com.polytech.repository"})
@EntityScan("com.polytech.business")
public class ApplicationConfig {

   // @Bean
   // public DataSource dataSource() {
    //    return (new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("create-schema.sql").build());
   // }

   /* @Value("${datasource.driverName}")
    private String driverClassName;

    @Value("${datasource.url}")
    private String url;

    @Value("${datasource.username}")
    private String username;

    @Value("${datasource.password}")
    private String password;*/

    @Autowired
    private Environment environment;

    @Bean(name = "dataSource")
    @Profile("PROD")
    public DataSource prodDataSource(){

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(environment.getProperty("dataSource.driverName"));
        dataSource.setUrl(environment.getProperty("dataSource.url"));
        dataSource.setUsername(environment.getProperty("dataSource.username"));
        dataSource.setPassword(environment.getProperty("dataSource.password"));
        return dataSource;
    }

    @Bean(name = "dataSource")
    @Profile("DEV")
    public DataSource devDataSource(){
        EmbeddedDatabaseBuilder embeddedDatabaseBuilder = new EmbeddedDatabaseBuilder();
        return embeddedDatabaseBuilder.setType(EmbeddedDatabaseType.H2).addScript("create-schema.sql").build();
    }
}
