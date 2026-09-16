-- =========================================================================
-- ADVANCED IT CAPSTONE: MASTER DATABASE SCHEMA
-- TEAM NAME: [Student Team Name Here]
-- TARGET SYSTEM: SQLite3
-- =========================================================================


-- =========================================================================
-- 1. CLEAR EXISTING TABLES
-- =========================================================================
CREATE TABLE library (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    title TEXT, 
    author TEXT,
    lexile INTEGER,
    genre TEXT);

INSERT INTO library 
    (title, author, lexile, genre) VALUES 
    ('49 Miles Alone', 'Natlalie D. Richards', 620, 'suspense'), 
    ('The Code Breaker', 'Walter Isaacson', 1180, 'science'),
    ('A Good Girls Guide to Murder', 'Holly Jackson', 700, 'suspense'),
    ('The Dysfunctional Family''s Guide to Murder', 'Kate Emery', Null, 'Young Adult'),
    ('The Love Hypothesis', 'Ali Hazelwood', 620, 'Romance'),
    ('Cinder', 'Marissa Meyer', 700, 'Fantasy'),
    ('The Diary of a Young Girl', 'Anne Frank', 720, 'Nonfiction'),
    ('Diary of a Wimpy Kid', 'Jeff Kinney', 500, 'Realistic Fiction'),
    ('Artemis Fowl', 'Eoin Colfer', 540, 'Science Fiction'),
    ('Six of Crows', 'Leigh Bardugo', 720, 'Fantasy'),
    ('The Long Walk', 'Stephen King', 700, 'Dystopian'),
    ('JoJo''s Bizarre Adventure: Battle Tendency Vol 1', 'Hirohiko Araki', 600, 'Manga'), 
    ('Welcome to the Ballroom Heat 2', 'Tomo Takeuchi', NULL, 'Sports')
    ('A Beautiful and Terrible Murder', 'Claire Andrews', NULL, 'Mystery'),
    ('The Hunger Games', 'Suzanne Collins', 810, 'Dystopian'),
    ('Percy Jackson & the Olympians: The Lightning Thief', 'Rick Riordan', 680, 'Fantasy'),
    ('Harry Potter and the Sorcerer''s Stone', 'J.K. Rowling', 880, 'Fantasy'),
    ('The Book Thief', 'Markus Zusak', 730, 'Historical Fiction'),
    ('To Kill a Mockingbird', 'Harper Lee', 870, 'Classic Fiction'),
    ('Fahrenheit 451', 'Ray Bradbury', 890, 'Dystopian'),
    ('The Giver', 'Lois Lowry', 760, 'Dystopian'),
    ('The Fault in Our Stars', 'John Green', 850, 'Realistic Fiction'),
    ('Divergent', 'Veronica Roth', 700, 'Dystopian'),
    ('One of Us Is Lying', 'Karen M. McManus', 730, 'Mystery'),
    ('Legend', 'Marie Lu', 710, 'Dystopian'),
    ('Holes', 'Louis Sachar', 660, 'Adventure'),
    ('The Maze Runner', 'James Dashner', 770, 'Sci-Fi');



-- =========================================================================
-- 2. USERS TABLE
-- =========================================================================

CREATE TABLE users (
    user_id INTEGER PRIMARY KEY AUTOINCREMENT,
    username TEXT NOT NULL UNIQUE,
    password_hash TEXT NOT NULL,
    email TEXT NOT NULL UNIQUE,
    user_role TEXT NOT NULL DEFAULT 'citizen',
    account_created TEXT DEFAULT CURRENT_TIMESTAMP
);



-- =========================================================================
-- 3. COMMUNITY RESOURCES TABLE
-- =========================================================================

CREATE TABLE community_resources (
    resource_id INTEGER PRIMARY KEY AUTOINCREMENT,
    resource_name TEXT NOT NULL,
    category TEXT NOT NULL,
    description TEXT,
    quantity_available INTEGER NOT NULL DEFAULT 0,
    managed_by_user_id INTEGER,

    FOREIGN KEY (managed_by_user_id)
        REFERENCES users(user_id)
        ON DELETE SET NULL
);


-- =========================================================================
-- 4. REQUESTS TABLE
-- =========================================================================

CREATE TABLE requests (
    request_id INTEGER PRIMARY KEY AUTOINCREMENT,
    user_id INTEGER NOT NULL,
    request_title TEXT NOT NULL,
    request_author TEXT NOT NULL,
    request_genre TEXT NOT NULL,
    quantity_requested INTEGER NOT NULL DEFAULT 1,
    status TEXT NOT NULL DEFAULT 'pending',
    request_date TEXT DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (user_id)
        REFERENCES users(user_id)
        ON DELETE CASCADE
);


-- =========================================================================
-- 5. DONATIONS TABLE
-- =========================================================================

CREATE TABLE donations (
    donation_id INTEGER PRIMARY KEY AUTOINCREMENT,
    user_id INTEGER NOT NULL,
    resource_id INTEGER NOT NULL,
    donation_date TEXT DEFAULT CURRENT_TIMESTAMP,
    quantity_donated INTEGER NOT NULL DEFAULT 1,
    notes TEXT,

    FOREIGN KEY (user_id)
        REFERENCES users(user_id)
        ON DELETE CASCADE,

    FOREIGN KEY (resource_id)
        REFERENCES community_resources(resource_id)
        ON DELETE CASCADE
);


-- =========================================================================
-- 6. INSERT MOCK USERS
-- =========================================================================

INSERT INTO users
    (username, password_hash, email, user_role)
VALUES
    ('admin_sarah', 'ef92b778', 'sarah@foodbank.org', 'admin'),

    ('volunteer_tim', '5e884898', 'tim.jones@school.edu', 'volunteer'),

    ('citizen_jane', '86f7e437', 'jane.doe@gmail.com', 'citizen'),
    ( 'mmichael', 'fnaf1983', 'matthewsmichaelg@scps.net', 'citizen'),
    ( 'cdarya', 'something', 'cherrydarya@scps.net', 'citizen')
    ( 'csamman', 'qwerty', 'sammancaseyk@scps.net', 'citizen');

-- =========================================================================
-- 8. INSERT MOCK REQUESTS
-- =========================================================================

INSERT INTO requests
    (user_id, request_title, request_author, request_genre, quantity_requested, status)
VALUES
    (3, 'Fahrenheit 451', 'Ray Bradbury', 'Dystopian', 1, 'pending'),
    (4, 'To Kill a Mockingbird', 'Harper Lee', 'Classic Fiction', 1, 'approved'),
    (1, '1984', 'George Orwell', 'Dystopian', 2, 'pending');


-- =========================================================================
-- 10. TEST 1 - DISPLAY ALL USERS
-- =========================================================================

SELECT * FROM users;


-- =========================================================================
-- 11. TEST 2 - DISPLAY ALL COMMUNITY RESOURCES
-- =========================================================================

SELECT * FROM community_resources;


-- =========================================================================
-- 12. TEST 3 - SHOW WHO MANAGES EACH RESOURCE
-- =========================================================================

SELECT
    community_resources.resource_name,
    community_resources.category,
    community_resources.quantity_available,
    users.username AS managed_by
FROM community_resources
JOIN users
    ON community_resources.managed_by_user_id = users.user_id;


-- =========================================================================
-- 13. TEST 4 - SHOW ALL RESOURCE REQUESTS
-- =========================================================================

SELECT
    users.username AS requester,
    community_resources.resource_name,
    requests.quantity_requested,
    requests.status,
    requests.request_date
FROM requests
JOIN users
    ON requests.user_id = users.user_id
JOIN community_resources
    ON requests.resource_id = community_resources.resource_id;


-- =========================================================================
-- 14. TEST 5 - SHOW ALL DONATIONS
-- =========================================================================

SELECT
    users.username AS donor,
    community_resources.resource_name,
    donations.quantity_donated,
    donations.notes,
    donations.donation_date
FROM donations
JOIN users
    ON donations.user_id = users.user_id
JOIN community_resources
    ON donations.resource_id = community_resources.resource_id;


-- =========================================================================
-- 15. TEST 6 - SHOW EVERYTHING TOGETHER
-- =========================================================================

SELECT
    users.username,
    users.user_role,
    community_resources.resource_name,
    community_resources.category,
    community_resources.quantity_available
FROM users
LEFT JOIN community_resources
    ON users.user_id = community_resources.managed_by_user_id
ORDER BY users.user_id;