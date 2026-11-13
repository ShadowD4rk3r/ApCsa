package org.communityapp;

import org.communityapp.data.UserDAO;
import org.communityapp.model.User;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        List<User> allUsers = userDAO.getAllUsers();

        System.out.println("Loaded " + allUsers.size() + " users from community_app.db:");
        for (User user : allUsers) {
            System.out.println(user);
        }
    }
}