package com.telecom.operator.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.telecom.operator.util.DBConnectionUtil;

public class UserDao {

    private static final String AUTHENTICATE_SQL =
            "SELECT password FROM users WHERE username = ?";

    public boolean authenticate(String username, String password) {

        try (Connection connection = DBConnectionUtil.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(AUTHENTICATE_SQL)) {

            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();

            if (!resultSet.next()) {
                return false;
            }

            String storedPassword = resultSet.getString("password");

            return storedPassword.equals(password);

        } catch (Exception ex) {
            throw new RuntimeException(
                    "Database authentication failed.", ex);
        }
    }
}