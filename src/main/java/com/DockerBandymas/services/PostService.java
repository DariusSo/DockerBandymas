package com.DockerBandymas.services;

import com.DockerBandymas.models.Post;
import com.DockerBandymas.repositories.PostRepository;

import java.sql.SQLException;
import java.util.List;

public class PostService {

    PostRepository ps = new PostRepository();

    public void createPost(Post p) throws SQLException {
        ps.createPost(p);
    }
    public List<Post> getPosts(int userId) throws SQLException {
        return ps.getPosts(userId);
    }
    public void updatePostContent(int id, String content) throws SQLException {
        ps.updatePostContent(id, content);
    }
    public void deletePost(int id) throws SQLException {
        ps.deletePost(id);
    }
}
