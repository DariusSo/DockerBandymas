package com.DockerBandymas.repositories;

import com.DockerBandymas.models.Post;
import com.DockerBandymas.utils.Connect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostRepository {

    public void createPost(Post p) throws SQLException {
        PreparedStatement ps = Connect.SQLConnection("INSERT INTO posts (user_id, title, content) VALUES (?,?,?)");
        ps.setInt(1, p.getUserId());
        ps.setString(2, p.getTitle());
        ps.setString(3, p.getContent());
        ps.execute();
    }
    public List<Post> getPosts(int userId) throws SQLException {
        List<Post> postList = new ArrayList<>();
        PreparedStatement ps = Connect.SQLConnection("SELECT * FROM posts WHERE user_id = ?");
        ps.setInt(1, userId);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Post post = new Post(rs.getInt("id"), rs.getInt("user_id"), rs.getString("title"), rs.getString("content"));
            postList.add(post);
        }
        return postList;
    }
    public void updatePostContent(int id, String content) throws SQLException {
        PreparedStatement ps = Connect.SQLConnection("UPDATE posts SET content = ? WHERE id = ?");
        ps.setString(1, content);
        ps.setInt(2, id);
        ps.execute();
    }
    public void deletePost(int id) throws SQLException {
        PreparedStatement ps = Connect.SQLConnection("DELETE FROM posts WHERE id = ?");
        ps.setInt(1, id);
        ps.execute();
    }
}
