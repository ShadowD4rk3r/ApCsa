package org.communityapp;

import org.communityapp.data.DatabaseConnection;
import org.communityapp.data.UserDAO;
import org.communityapp.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // ==========================================
        // LESSON 1: Establishing a JDBC Connection
        // ==========================================
        System.out.println("=== LESSON 1: JDBC Connection ===");
        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn != null && !conn.isClosed()) {
                System.out.println("JDBC Connection Successful! Connected to: " + conn.getMetaData().getURL());
            }
        } catch (SQLException e) {
            System.err.println("Lesson 1 Error: " + e.getMessage());
        }

        // ==========================================
        // LESSON 2: Executing Raw SQL via Statement
        // ==========================================
        System.out.println("\n=== LESSON 2: Raw SQL Query via Statement ===");
        String sql = "SELECT username, email, user_role FROM users";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println("Raw Row -> Username: " + rs.getString("username")
                        + " | Email: " + rs.getString("email")
                        + " | Role: " + rs.getString("user_role"));
            }
        } catch (SQLException e) {
            System.err.println("Lesson 2 Error: " + e.getMessage());
        }

        // ==========================================
        // LESSON 3 & 4: ResultSet -> ArrayList<User> + Try-With-Resources
        // ==========================================
        System.out.println("\n=== LESSON 3 & 4: UserDAO (Object Mapping & Try-With-Resources) ===");
        UserDAO userDAO = new UserDAO();
        List<User> userList = userDAO.getAllUsers();

        System.out.println("Mapped " + userList.size() + " rows into User objects:");
        for (User u : userList) {
            System.out.println(u.toString());
        }
    }
}