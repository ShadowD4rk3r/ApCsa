import LegacyUser.java;
public class Main {
    public static void main(String[] args) {
        LegacyUser user = new LegacyUser();
        user.passwordHash = "hacked123"; // Direct property access

        System.out.println("--- TESTING ENCAPSULATION & VALIDATION ---");

        // Step A: Set values safely using public setters
        user.setUserId(101);
        user.setUsername("dev_user");
        user.setPasswordHash("e99a18c428cb38d5f260853678922e03");
        user.setUserRole("ADMIN");

        // Step B: Test valid email input
        System.out.print("Testing valid email: ");
        user.setEmail("student@school.edu");
        System.out.println("Saved Email -> " + user.getEmail());

        // Step C: Test invalid email input (Validation Logic)
        System.out.print("Testing invalid email: ");
        user.setEmail("invalidemail.com"); // Should trigger error output
        System.out.println("Email after invalid attempt -> " + user.getEmail());

        // Step D: Print full user details using getters
        System.out.println("\n--- FINAL USER RECORD ---");
        System.out.println("ID: " + user.getUserId());
        System.out.println("Username: " + user.getUsername());
        System.out.println("Role: " + user.getUserRole());
    }
}