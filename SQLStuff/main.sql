-- =========================================================================
-- ADVANCED IT CAPSTONE: MASTER DATABASE SCHEMA
-- TEAM NAME: [Student Team Name Here]
-- TARGET SYSTEM: SQLite3
-- =========================================================================


-- =========================================================================
-- 1. CLEAR EXISTING TABLES
-- =========================================================================

DROP TABLE IF EXISTS requests;
DROP TABLE IF EXISTS donations;
DROP TABLE IF EXISTS community_resources;
DROP TABLE IF EXISTS users;


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
    resource_id INTEGER NOT NULL,
    request_date TEXT DEFAULT CURRENT_TIMESTAMP,
    quantity_requested INTEGER NOT NULL DEFAULT 1,
    status TEXT NOT NULL DEFAULT 'pending',

    FOREIGN KEY (user_id)
        REFERENCES users(user_id)
        ON DELETE CASCADE,

    FOREIGN KEY (resource_id)
        REFERENCES community_resources(resource_id)
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

    ('citizen_jane', '86f7e437', 'jane.doe@gmail.com', 'citizen');


-- =========================================================================
-- 7. INSERT MOCK COMMUNITY RESOURCES
-- =========================================================================

INSERT INTO community_resources
    (resource_name, category, description, quantity_available, managed_by_user_id)
VALUES
    (
        'Non-Perishable Canned Goods',
        'Food',
        'Assorted vegetables and soups',
        150,
        1
    ),

    (
        'Winter Coats (Adult Large)',
        'Clothing',
        'Heavy duty winter jackets',
        12,
        1
    ),

    (
        'Math Tutoring - 2 Hours',
        'Education',
        'High school algebra support',
        3,
        2
    );


-- =========================================================================
-- 8. INSERT MOCK REQUESTS
-- =========================================================================

INSERT INTO requests
    (user_id, resource_id, quantity_requested, status)
VALUES
    (3, 1, 10, 'pending'),

    (3, 2, 1, 'approved'),

    (3, 3, 1, 'pending');


-- =========================================================================
-- 9. INSERT MOCK DONATIONS
-- =========================================================================

INSERT INTO donations
    (user_id, resource_id, quantity_donated, notes)
VALUES
    (
        2,
        1,
        25,
        'Donated canned vegetables'
    ),

    (
        2,
        2,
        5,
        'Winter coats collected from school drive'
    ),

    (
        1,
        3,
        2,
        'Purchased tutoring sessions'
    );


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