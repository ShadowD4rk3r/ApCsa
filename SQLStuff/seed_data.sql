
-- CLEAR EXISTING DATA
DELETE FROM requests;
DELETE FROM donations;
DELETE FROM community_resources;
DELETE FROM users;



-- INSERT MOCK USERS
INSERT INTO users (username, password_hash, email, user_role) VALUES
('admin_sarah', 'ef92b778', 'sarah@foodbank.org', 'admin'),
('volunteer_tim', '5e884898', 'tim.jones@school.edu', 'volunteer'),
('citizen_jane', '86f7e437', 'jane.doe@gmail.com', 'citizen');


-- INSERT MOCK COMMUNITY RESOURCES
INSERT INTO community_resources
    (resource_name, category, description, quantity_available, managed_by_user_id)
VALUES
('Non-Perishable Canned Goods',
    'Food',
    'Assorted vegetables and soups',
    150,
    1),

('Winter Coats (Adult Large)',
    'Clothing',
    'Heavy duty winter jackets',
    12,
    1),

('Math Tutoring - 2 Hours',
    'Education',
    'High school algebra support',
    3,
    2);



-- INSERT MOCK REQUESTS
INSERT INTO requests
    (user_id, resource_id, quantity_requested, status)
VALUES
(3, 1, 10, 'pending'),
(3, 2, 1, 'approved'),
(3, 3, 1, 'pending');


-- INSERT MOCK DONATIONS
INSERT INTO donations
    (user_id, resource_id, quantity_donated, notes)
VALUES
(2, 1, 25, 'Donated canned vegetables'),
(2, 2, 5, 'Winter coats collected from school drive'),
(1, 3, 2, 'Purchased tutoring sessions');