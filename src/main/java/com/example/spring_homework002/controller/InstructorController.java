package com.example.spring_homework002.controller;

import com.example.spring_homework002.model.Instructor;
import com.example.spring_homework002.model.dto.request.InstructorRequest;
import com.example.spring_homework002.model.dto.response.ApiResponse;
import com.example.spring_homework002.model.dto.response.InstructorResponse;
import com.example.spring_homework002.service.InstructorService;
import org.mybatis.logging.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/instructors")
public class InstructorController {
    private final InstructorService instructorService;
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }
    @GetMapping("")
    public ResponseEntity<?> getAllInstructors() {
//        System.out.println("Get all instructors: " + instructorService.getAllInstructors());
        ApiResponse<?> response = ApiResponse.builder()
                .message("Get all instructors")
                .payload(instructorService.getAllInstructors())
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getInstructorById(@PathVariable("id") Integer id) {
        ApiResponse<?> response = ApiResponse.builder()
                .message("Get instructor by Id: " + id)
                .payload(instructorService.getInstructorById(id))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("")
    public ResponseEntity<?> addInstructor(@RequestBody InstructorRequest instructorRequest) {
        ApiResponse<?> response = ApiResponse.builder()
                .message("Create an instructor")
                .payload(instructorService.addInstructor(instructorRequest))
                .status(HttpStatus.CREATED)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteInstructorById(@PathVariable("id")  Integer id){
        instructorService.deleteInstructorById(id);
        ApiResponse<?> response = ApiResponse.builder()
                .message("Delete an instructor by Id: " + id)
                .payload(null)
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateInstructorById(@PathVariable("id") Integer id, @RequestBody InstructorRequest instructorRequest){
        ApiResponse<?> response = ApiResponse.builder()
                .message("Update an instructor by Id: " + id)
                .payload(instructorService.updateInstructorById(id, instructorRequest))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
