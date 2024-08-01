package com.DockerBandymas.repositories;

import com.DockerBandymas.models.User;
import com.DockerBandymas.utils.Connect;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {
    public void createUser(User u) throws SQLException {
        PreparedStatement ps = Connect.SQLConnection("INSERT INTO users (name, email) values (?,?)");
        ps.setString(1, u.getName());
        ps.setString(2, u.getEmail());
        ps.execute();
    }
    public User getUser(int id) throws SQLException {
        User user = null;
        PreparedStatement ps = Connect.SQLConnection("SELECT * FROM users WHERE id = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"));
        }
        return user;
    }
    public void modifyUser(User u) throws SQLException {
        PreparedStatement ps = Connect.SQLConnection("UPDATE users SET name = ?, email = ? WHERE id = ?");
        ps.setString(1, u.getName());
        ps.setString(2, u.getEmail());
        ps.setInt(3, u.getId());
        ps.execute();
    }
    public void deleteUser(int id) throws SQLException {
        PreparedStatement ps = Connect.SQLConnection("DELETE FROM users WHERE id = ?");
        ps.setInt(1, id);
        ps.execute();
    }
}
