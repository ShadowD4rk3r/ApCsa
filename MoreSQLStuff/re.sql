-- Load the existing community_app.db database
.read community_app.sql

-- Configure table display format once
.mode box
.headers on

-- ==========================================
-- TEST 1: MULTI-FILTER SEARCH
-- ==========================================
.print "=========================================="
.print "TEST 1: MULTI-FILTER SEARCH"
.print "=========================================="
SELECT username, email 
FROM users 
WHERE user_role = 'citizen' AND user_id > 1;

-- ==========================================
-- TEST 2: DOMAIN INSPECTOR
-- ==========================================
.print "=========================================="
.print "TEST 2: DOMAIN INSPECTOR"
.print "=========================================="
SELECT * 
FROM users 
WHERE email NOT LIKE '%@school.edu';

-- ==========================================
-- TEST 3: INVENTORY LEADERBOARD
-- ==========================================
.print "=========================================="
.print "TEST 3: INVENTORY LEADERBOARD"
.print "=========================================="
SELECT resource_name, category, quantity_available 
FROM community_resources 
ORDER BY quantity_available DESC;

-- ==========================================
-- TEST 4: BOSS BATTLE
-- ==========================================
.print "=========================================="
.print "TEST 4: BOSS BATTLE"
.print "=========================================="
SELECT * 
FROM community_resources 
WHERE resource_name LIKE '%food%' 
  AND quantity_available > 0 
ORDER BY resource_name ASC;