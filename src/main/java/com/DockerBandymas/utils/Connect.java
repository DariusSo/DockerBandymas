package com.DockerBandymas.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Connect {

    private static final String URL = "jdbc:mysql://host.docker.internal:3307/dockerUzduotis";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "my-secret-pw";

    private static Connection connection;

    public static PreparedStatement SQLConnection(String sqls) throws SQLException {
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        String sql = sqls;
        PreparedStatement ps = connection.prepareStatement(sql);
        return ps;
    }

}
