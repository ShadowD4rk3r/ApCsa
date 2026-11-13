-- 1. Create the 'users' table
CREATE TABLE IF NOT EXISTS users (
    user_id INTEGER PRIMARY KEY AUTOINCREMENT,
    username TEXT NOT NULL,
    email TEXT NOT NULL UNIQUE,
    user_role TEXT NOT NULL
);

-- 2. Create the 'community_resources' table
CREATE TABLE IF NOT EXISTS community_resources (
    resource_id INTEGER PRIMARY KEY AUTOINCREMENT,
    resource_name TEXT NOT NULL,
    category TEXT NOT NULL,
    quantity_available INTEGER NOT NULL
);

-- 3. Insert sample data into 'users'
INSERT INTO users (username, email, user_role) VALUES
('alice_admin', 'alice@community.org', 'admin'),
('bob_builder', 'bob@gmail.com', 'citizen'),
('charlie_vol', 'charlie@school.edu', 'volunteer'),
('diana_c', 'diana@gmail.com', 'citizen'),
('evan_student', 'evan@school.edu', 'citizen');

-- 4. Insert sample data into 'community_resources'
INSERT INTO community_resources (resource_name, category, quantity_available) VALUES
('Canned Food Pack', 'Food', 25),
('Warm Jackets', 'Clothing', 5),
('Bottled Water (Food Grade)', 'Food', 100),
('First Aid Kit', 'Medical', 0),
('Baby Food Formula', 'Food', 12);