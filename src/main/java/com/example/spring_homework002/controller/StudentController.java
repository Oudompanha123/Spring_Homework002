package com.example.spring_homework002.controller;

import com.example.spring_homework002.model.Student;
import com.example.spring_homework002.model.dto.request.StudentRequest;
import com.example.spring_homework002.model.dto.response.ApiResponse;
import com.example.spring_homework002.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("")
    public ResponseEntity<?> getAllStudent(){
        studentService.getAllStudent();
        ApiResponse<?> response = ApiResponse.builder()
                .message("Get all books")
                .payload(studentService.getAllStudent())
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") Integer id){
        ApiResponse<?> apiResponse = ApiResponse.builder()
                .message("Get book by id: " + id)
                .payload(studentService.getStudentById(id))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable("id") Integer id){
        studentService.deleteStudentById(id);
        ApiResponse<?> apiResponse = ApiResponse.builder()
                .message("Delete book by id: " + id)
                .payload(null)
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("")
    public ResponseEntity<?> createStudent(@RequestBody StudentRequest studentRequest){
        studentService.createStudent(studentRequest);
        ApiResponse<?> apiResponse = ApiResponse.builder()
                .message("Add new book")
                .payload(studentService.createStudent(studentRequest))
                .status(HttpStatus.CREATED)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable("id") Integer id, StudentRequest studentRequest){
        ApiResponse<?> apiResponse = ApiResponse.builder()
                .message("Update book by ID: " + id)
                .payload(studentService.updateStudent(id, studentRequest))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
}
