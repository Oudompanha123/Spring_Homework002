package com.example.spring_homework002.service;

import com.example.spring_homework002.model.Student;
import com.example.spring_homework002.model.dto.request.StudentRequest;

import java.awt.print.Book;
import java.util.List;

public interface StudentService {

    List<Student> getAllStudent();

    Student getStudentById(Integer id);

    Student deleteStudentById(Integer id);

    Student createStudent(StudentRequest studentRequest);
}
