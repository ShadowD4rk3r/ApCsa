-- =========================================================================
-- ADVANCED IT CAPSTONE: MASTER DATABASE SCHEMA
-- TARGET SYSTEM: SQLite3
-- =========================================================================

-- Drop tables so the script can be rerun cleanly
DROP TABLE IF EXISTS community_resources;
DROP TABLE IF EXISTS users;

-- 1. USERS TABLE
CREATE TABLE users (
    user_id INTEGER PRIMARY KEY AUTOINCREMENT,
    username TEXT NOT NULL UNIQUE,
    password_hash TEXT NOT NULL,
    email TEXT NOT NULL UNIQUE,
    user_role TEXT NOT NULL DEFAULT 'citizen',
    account_created TEXT DEFAULT CURRENT_TIMESTAMP
);

-- 2. COMMUNITY RESOURCES TABLE
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

-- 3. REQUEST OF COMMUNITY RESOURCES
CREATE TABLE requests (
    request_id INTEGER PRIMARY KEY AUTOINCREMENT,
    user_id INTEGER NOT NULL,
    resource_id INTEGER NOT NULL,
    request_date TEXT DEFAULT CURRENT_TIMESTAMP,
    quantity_requested INTEGER NOT NULL DEFAULT 1,
    status TEXT NOT NULL DEFAULT 'pending',
    FOREIGN KEY (user_id) REFERENCES users(user_id)
        ON DELETE CASCADE,
    FOREIGN KEY (resource_id) REFERENCES community_resources(resource_id)
        ON DELETE CASCADE
);

-- 4. PEOPLE DONATING TO COMMUNITY RESOURCES
CREATE TABLE donations (
    donation_id INTEGER PRIMARY KEY AUTOINCREMENT,
    user_id INTEGER NOT NULL,
    resource_id INTEGER NOT NULL,
    donation_date TEXT DEFAULT CURRENT_TIMESTAMP,
    quantity_donated INTEGER NOT NULL DEFAULT 1,
    notes TEXT,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
        ON DELETE CASCADE,
    FOREIGN KEY (resource_id) REFERENCES community_resources(resource_id)
        ON DELETE CASCADE
);