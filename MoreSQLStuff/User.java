public class User {

    private int userId;
    private String username;
    private String email;
    private String userRole;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "User [ID=" + userId +
                ", Username='" + username + '\'' +
                ", Email='" + email + '\'' +
                ", Role='" + userRole + "']";
    }
}