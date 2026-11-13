public class Main2 {
    public static void main(String[] args) {
        // Scenario A: Existing User loaded from DB (ID = 42)
        User existingUser = new User(42, "db_sarah", "hash8923", "sarah@tech.org", "admin");

        // Scenario B: New user signing up on the mobile app right now (No ID assigned yet!)
        User newUser = new User("signup_tim", "hash5511", "tim@school.edu", "citizen");

        // Print both user objects
        System.out.println("Existing DB User: " + existingUser);
        System.out.println("New App Registration: " + newUser);
    }
}