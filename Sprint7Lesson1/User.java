
package org.communityapp.model;

public class User {

    private int userId;
    private String username;
    private String email;
    private String userRole;

    public User(int userId, String username, String email, String userRole) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.userRole = userRole;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getUserRole() {
        return userRole;
    }
}
