package com.DockerBandymas.controllers;

import com.DockerBandymas.models.Post;
import com.DockerBandymas.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class PostController {

    PostService postService = new PostService();

    @PostMapping("/createPost")
    public void createPost(@RequestBody Post p) throws SQLException {
        postService.createPost(p);
    }
    @GetMapping("/getPosts")
    public List<Post> getPosts(int userId) throws SQLException {
        return postService.getPosts(userId);
    }
    @PutMapping("/updateContent")
    public void updatePostContent(int id, String content) throws SQLException {
        postService.updatePostContent(id, content);
    }
    @DeleteMapping("/deletePost")
    public void deletePost(int id) throws SQLException {
        postService.deletePost(id);
    }
}
