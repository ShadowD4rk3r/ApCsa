package org.communityapp.data;

import org.communityapp.model.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT user_id, username, email, role FROM users";

        // Lesson 4: try-with-resources automatically closes conn, stmt, and rs
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // Lesson 2 & 3: Iterate through cursor rows and build User objects
            while (rs.next()) {
                int id = rs.getInt("user_id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String role = rs.getString("role");

                users.add(new User(id, username, email, role));
            }

        } catch (SQLException e) {
            System.err.println("Database Error: " + e.getMessage());
        }

        return users;
    }
}