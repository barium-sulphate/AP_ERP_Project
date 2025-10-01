-- DROP DATABASE IF EXISTS erp_db;
-- CREATE DATABASE erp_db;

USE erp_db;

DROP TABLE IF EXISTS students;
CREATE TABLE students (
    user_id INT PRIMARY KEY,
    roll_no VARCHAR(20),
    program VARCHAR(50),
    year INT
);

DROP TABLE IF EXISTS instructors;
CREATE TABLE instructors (
    user_id INT PRIMARY KEY,
    department VARCHAR(50)
);

DROP TABLE IF EXISTS courses;
CREATE TABLE courses (
    course_id INT PRIMARY KEY AUTO_INCREMENT,
    code VARCHAR(10),
    title VARCHAR(100),
    credits INT
);