package com.example.spring_homework002.service;

import com.example.spring_homework002.model.Student;
import com.example.spring_homework002.model.dto.request.StudentRequest;
import com.example.spring_homework002.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Book;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudent() {
        studentRepository.getAllStudent();
        return studentRepository.getAllStudent();
    }


    @Override
    public Student getStudentById(Integer id) {
        return studentRepository.getStudentById(id);
    }

    @Override
    @Transactional
    public Student deleteStudentById(Integer id) {
        System.out.println("Student: " + studentRepository.deleteStudent(id));
        return studentRepository.deleteStudent(id);
    }
    @Override
    @Transactional
    public Student createStudent(StudentRequest studentRequest) {
        Student student = studentRepository.insertStudent(studentRequest);
        System.out.println("Id of student: " + student.getStudentId());
        System.out.println("Add Student: " + studentRequest);

      if(studentRequest.getCourseId() != null){
           for(Integer courseId : studentRequest.getCourseId()){
             System.out.println("Get course Id: " + courseId);
             studentRepository.insertIntoStudentCourse(student.getStudentId(), courseId);
          }
      }
        return studentRepository.getStudentById(student.getStudentId());
        //return null;
    }
}
