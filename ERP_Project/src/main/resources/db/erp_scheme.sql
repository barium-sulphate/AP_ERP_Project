CREATE DATABASE IF NOT EXISTS erp_db;
USE erp_db;

-- ============================
-- STUDENTS
-- ============================
CREATE TABLE IF NOT EXISTS students (
    user_id INT PRIMARY KEY,
    roll_no VARCHAR(20),
    program VARCHAR(50),
    year INT
    );

-- ============================
-- INSTRUCTORS
-- ============================
CREATE TABLE IF NOT EXISTS instructors (
    user_id INT PRIMARY KEY,
    department VARCHAR(50)
    );

-- ============================
-- COURSES
-- ============================
CREATE TABLE IF NOT EXISTS courses (
    course_id INT PRIMARY KEY AUTO_INCREMENT,
    code VARCHAR(10) UNIQUE,
    title VARCHAR(100),
    credits INT
    );

INSERT INTO courses (code, title, credits) VALUES
    ('CS101', 'Introduction to Computer Science', 4),
    ('MA105', 'Calculus I', 3),
    ('PH102', 'Physics for Engineers', 4)
    ON DUPLICATE KEY UPDATE
        title = VALUES(title),
        credits = VALUES(credits);

-- ============================
-- SECTIONS
-- ============================
CREATE TABLE IF NOT EXISTS sections (
                                        section_id INT PRIMARY KEY AUTO_INCREMENT,
                                        course_id INT,
                                        instructor_id INT,
                                        day VARCHAR(10),
    start_time TIME,
    end_time TIME,
    room VARCHAR(20),
    capacity INT,
    semester VARCHAR(10),
    year INT,
    FOREIGN KEY (course_id) REFERENCES courses(course_id)
    );

INSERT IGNORE INTO sections
(course_id, instructor_id, day, start_time, end_time, room, capacity, semester, year)
VALUES
    (1, 10, 'Mon', '09:00', '10:30', 'A101', 40, 'Monsoon', 2024),
    (1, 11, 'Wed', '09:00', '10:30', 'A101', 40, 'Monsoon', 2024),
    (2, 20, 'Tue', '11:00', '12:30', 'B204', 50, 'Monsoon', 2024),
    (2, 21, 'Thu', '11:00', '12:30', 'B204', 50, 'Monsoon', 2024),
    (3, 30, 'Mon', '14:00', '15:30', 'C301', 35, 'Monsoon', 2024),
    (3, 31, 'Fri', '14:00', '15:30', 'C301', 35, 'Monsoon', 2024);

-- ============================
-- ENROLLMENTS
-- ============================
CREATE TABLE IF NOT EXISTS enrollments (
                                           enrollment_id INT PRIMARY KEY AUTO_INCREMENT,
                                           student_id INT,
                                           section_id INT,
                                           status VARCHAR(10) DEFAULT 'ENROLLED',
    UNIQUE(student_id, section_id),
    FOREIGN KEY (student_id) REFERENCES students(user_id),
    FOREIGN KEY (section_id) REFERENCES sections(section_id)
    );
