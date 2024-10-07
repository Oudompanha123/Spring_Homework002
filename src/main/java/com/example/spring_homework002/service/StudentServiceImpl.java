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
    public void deleteStudentById(Integer id) {
        if(studentRepository.getStudentById(id) != null) {
            System.out.println("Student: " + studentRepository.deleteStudentById(id));
        }else {
            System.out.println("Student " + id + " not found" );
        }

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
    @Override
    @Transactional
    public Student updateStudent(Integer id, StudentRequest studentRequest) {
        Student student = studentRepository.updateStudentById(id, studentRequest);
        System.out.println("New Student info: " + student);
        System.out.println("Id of student: " + id);
        System.out.println("Update Student: " + studentRequest);

      if(studentRequest.getCourseId() != null){
          for(Integer courseId : studentRequest.getCourseId()){
              System.out.println("Get course Id: " + courseId);
              studentRepository.updateIntoStudentCourse(id, courseId);
          }
      }
        return studentRepository.getStudentById(id);
    }
}
