DROP DATABASE IF EXISTS auth_db;
CREATE DATABASE auth_db;

DROP DATABASE IF EXISTS erp_db;
CREATE DATABASE erp_db;

DROP USER IF EXISTS 'appuser'@'localhost';
CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'password123';
GRANT ALL PRIVILEGES ON auth_db.* TO 'appuser'@'localhost';
GRANT ALL PRIVILEGES ON erp_db.* TO 'appuser'@'localhost';
FLUSH PRIVILEGES;

