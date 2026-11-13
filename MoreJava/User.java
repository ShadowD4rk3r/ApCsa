package org.communityapp.data;

public class User {
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
}
```[cite: 2]

---

### 3. Testing Code (`Main.java`)
Code used to test both user creation scenarios[cite: 3]:

```java
// Scenario A: Existing User loaded from DB (ID = 42)
User existingUser = new User(42, "db_sarah", "hash8923", "sarah@tech.org", "admin");

// Scenario B: New user signing up on the mobile app right now (No ID assigned yet!)
User newUser = new User("signup_tim", "hash5511", "tim@school.edu", "citizen");

System.out.println("Existing DB User: " + existingUser);
System.out.println("New App Registration: " + newUser);
```[cite: 3]

---

### 4. Key Concept Summaries (ID Dilemma & Overloading)
* **The ID Dilemma:**
  * **Reading existing data:** Databases like SQLite generate primary keys (e.g., `userId = 101`), which Java must store when loading records[cite: 1].
  * **Creating new data:** When a user registers, SQLite assigns the ID via `AUTOINCREMENT`[cite: 1]. Passing an ID manually from Java during signup risks primary key conflicts in the database[cite: 1].
* **Constructor Overloading:** Creating multiple constructors within the same class that share the exact same name (`User`) but take different parameter lists to accommodate different object creation needs[cite: 1].
* **The `this` Keyword:** Used to distinguish instance variables from parameter variables when they share the same name (e.g., `this.username = username`)[cite: 2].

---