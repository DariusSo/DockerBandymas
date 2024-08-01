package com.DockerBandymas.controllers;

import com.DockerBandymas.models.User;
import com.DockerBandymas.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
public class UserController {
    UserService us = new UserService();

    @PostMapping("/createUser")
    public void createUser(@RequestBody User u) throws SQLException {
        us.createUser(u);
    }
    @GetMapping("/getUser")
    public User getUser(int id) throws SQLException {
        return us.getUser(id);
    }
    @PutMapping("/modifyUser")
    public void modifyUser(@RequestBody User u) throws SQLException {
        us.modifyUser(u);
    }
    @DeleteMapping("/deleteUser")
    public void deleteUser(int id) throws SQLException {
        us.deleteUser(id);
    }
}
