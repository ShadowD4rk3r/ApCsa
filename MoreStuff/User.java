
public class User {
    // Instance variables
    private int userId;
    private String username;
    private String passwordHash;
    private String email;
    private String userRole;

    // CONSTRUCTOR 1: For reading EXISTING users from SQLite (Includes ID)
    public User(int userId, String username, String passwordHash, String email, String userRole) {
        this.userId = userId;
        this.username = username;
        this.passwordHash = passwordHash;
        this.email = email;
        this.userRole = userRole;
    }

    // CONSTRUCTOR 2: For creating BRAND-NEW users before DB insert (OMITS ID!)
    public User(String username, String passwordHash, String email, String userRole) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.email = email;
        this.userRole = userRole;
    }

    // CONSTRUCTOR 3: Default No-Arg Constructor (Flexible empty setup)
    public User() {}

    // toString method for formatted console output
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", email='" + email + '\'' +
                ", userRole='" + userRole + '\'' +
                '}';
    }
}