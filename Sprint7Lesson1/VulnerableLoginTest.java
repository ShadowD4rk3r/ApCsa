
package org.communityapp.data;

import java.util.Scanner;

public class VulnerableLoginTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== SQL Injection Classroom Lab ===");

        System.out.print("Enter Username: ");
        String userInput = scanner.nextLine();

        System.out.print("Enter Password: ");
        String passInput = scanner.nextLine();

        // Demonstration only: NEVER execute this SQL.
        String sql = "SELECT * FROM users WHERE username = '"
                + userInput
                + "' AND password_hash = '"
                + passInput + "'";

        System.out.println("\n=== SQL Injection Analysis ===");

        System.out.println("DEBUG SQL GENERATED:");
        System.out.println(sql);

        System.out.println("\nSecurity Analysis:");

        if (userInput.contains("'")) {
            System.out.println(
                "WARNING: Username contains a SQL quote character."
            );

            System.out.println(
                "User input may alter the structure of a concatenated SQL query."
            );
        } else {
            System.out.println(
                "No SQL quote character detected in username."
            );
        }

        System.out.println("\nLAB RESULT:");
        System.out.println(
            "Query construction demonstrated. "
            + "No database query was executed."
        );

        scanner.close();
    }
}
