CREATE DATABASE homework002_db;

CREATE TABLE instructor (
    instructor_id SERIAL PRIMARY KEY ,
    instructor_name VARCHAR(100),
    email VARCHAR(100)
);

CREATE TABLE course (
    course_id SERIAL PRIMARY KEY,
    course_name VARCHAR(100),
    description TEXT,
    instructor_id INT,
    FOREIGN KEY (instructor_id) REFERENCES instructor(instructor_id)
);

CREATE TABLE student (
    student_id SERIAL PRIMARY KEY,
    student_name VARCHAR(100),
    email VARCHAR(100),
    phone_number VARCHAR(15)
);

CREATE TABLE student_course (
    id SERIAL PRIMARY KEY,
    student_id INT,
    course_id INT,
    FOREIGN KEY (student_id) REFERENCES student(student_id),
    FOREIGN KEY (course_id) REFERENCES course(course_id)
);