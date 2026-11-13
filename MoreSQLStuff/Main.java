
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        // Create a test User object
        User testUser = new User();

        testUser.setUserId(0);
        testUser.setUsername("alex_dev");
        testUser.setEmail("alex@tech.org");
        testUser.setUserRole("admin");

        System.out.println("Test User:");
        System.out.println(testUser);
        System.out.println("--------------------");

        String url = "jdbc:sqlite:community_app.db";

        try {

            // Load SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");

            Connection connection =
                DriverManager.getConnection(url);

            Statement statement =
                connection.createStatement();

            ResultSet resultSet =
                statement.executeQuery("SELECT * FROM users");

            while (resultSet.next()) {

                User user = new User();

                user.setUserId(resultSet.getInt("user_id"));
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setUserRole(resultSet.getString("user_role"));

                System.out.println(user);
                System.out.println("--------------------");
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
