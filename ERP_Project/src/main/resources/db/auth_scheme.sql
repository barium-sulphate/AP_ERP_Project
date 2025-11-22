-- DO NOT DROP DATABASE
CREATE DATABASE IF NOT EXISTS auth_db;
USE auth_db;

-- DO NOT DROP USERS OR RECREATE USERS
-- Users and permissions should be created once manually or in a setup script.

-- ============================
-- USERS_AUTH TABLE
-- ============================

CREATE TABLE IF NOT EXISTS users_auth (
                                          user_id INT PRIMARY KEY AUTO_INCREMENT,
                                          username VARCHAR(50) UNIQUE NOT NULL,
    role ENUM('ADMIN', 'INSTRUCTOR', 'STUDENT') NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    status VARCHAR(20) DEFAULT 'ACTIVE',
    last_login TIMESTAMP NULL
    );

-- ============================
-- DEFAULT USERS (insert only if missing)
-- ============================

INSERT INTO users_auth (username, role, password_hash)
VALUES
    ('admin1', 'ADMIN', 'password123'),
    ('inst1', 'INSTRUCTOR', 'password123'),
    ('stu1', 'STUDENT', 'password123')
    ON DUPLICATE KEY UPDATE
                         role = VALUES(role),
                         password_hash = VALUES(password_hash);
