package com.polytech.repository;

import com.polytech.business.Post;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 13/03/2017.
 */
public class PostRepositoryImpl implements PostRepository {

    private DataSource dataSource;

    public PostRepositoryImpl(DataSource datasource){
        this.dataSource = dataSource;
    }
    public List<Post> findAll() {
        List<Post> posts = new ArrayList<Post>();
        try{
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM POST");

            while (resultSet.next()){
                String content = resultSet.getString("CONTENT");
                Post post = new Post(content);
                posts.add(post);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return posts;
    }

    public void save(Post post) {
        try{
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO POST (CONTENT) VALUES(?)");
            preparedStatement.setString(1, post.getContent());
            preparedStatement.execute();

        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

}
