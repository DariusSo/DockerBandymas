package com.DockerBandymas.services;

import com.DockerBandymas.models.User;
import com.DockerBandymas.repositories.UserRepository;

import java.sql.SQLException;

public class UserService {

    UserRepository ur = new UserRepository();

    public void createUser(User u) throws SQLException {
        ur.createUser(u);
    }
    public User getUser(int id) throws SQLException {
        return ur.getUser(id);
    }
    public void modifyUser(User u) throws SQLException {
        ur.modifyUser(u);
    }
    public void deleteUser(int id) throws SQLException {
        ur.deleteUser(id);
    }
}
