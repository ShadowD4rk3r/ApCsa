public class LegacyUser {
    // Encapsulated instance variables (Personal Safe)
    private int userId;
    private String username;
    private String passwordHash;
    private String email;
    private String userRole;

    // --- GETTERS AND SETTERS ---

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

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getEmail() {
        return email;
    }

    // Input Validation applied to prevent invalid email formats
    public void setEmail(String email) {
        if (email != null && email.contains("@")) {
            this.email = email;
        } else {
            System.err.println("INVALID EMAIL: Update rejected.");
        }
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}