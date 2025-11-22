CREATE DATABASE IF NOT EXISTS auth_db;
CREATE DATABASE IF NOT EXISTS erp_db;

-- Create user only if not exists (MariaDB/MySQL 10.5+ supports IF NOT EXISTS)
CREATE USER IF NOT EXISTS 'appuser'@'localhost' IDENTIFIED BY 'password123';

-- Grant privileges (idempotent)
GRANT ALL PRIVILEGES ON auth_db.* TO 'appuser'@'localhost';
GRANT ALL PRIVILEGES ON erp_db.* TO 'appuser'@'localhost';

FLUSH PRIVILEGES;
