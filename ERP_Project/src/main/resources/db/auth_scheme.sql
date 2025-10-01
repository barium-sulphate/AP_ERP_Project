-- DROP DATABASE IF EXISTS auth_db;
-- CREATE DATABASE auth_db;

USE auth_db;

-- DROP USER IF EXISTS 'appuser'@'localhost';
-- CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'password123';
-- GRANT ALL PRIVILEGES ON auto_scheme.* TO 'appuser'@'localhost';
-- GRANT ALL PRIVILEGES ON erp_db.* TO 'appuser'@'localhost';
-- FLUSH PRIVILEGES;

DROP TABLE IF EXISTS users_auth;
CREATE TABLE users_auth (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    role ENUM('ADMIN', 'INSTRUCTOR', 'STUDENT') NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    status VARCHAR(20) DEFAULT 'ACTIVE',
    last_login TIMESTAMP NULL
);

INSERT INTO users_auth (username, role, password_hash) VALUES
('admin1', 'ADMIN', 'password123'),
('inst1', 'INSTRUCTOR', 'password123'),
('stu1', 'STUDENT', 'password123')
ON DUPLICATE KEY UPDATE
    role = VALUES(role),
    password_hash = VALUES(password_hash);
