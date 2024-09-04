package com.example.spring_homework002.controller;

import com.example.spring_homework002.model.Course;
import com.example.spring_homework002.model.dto.request.CourseRequest;
import com.example.spring_homework002.model.dto.response.ApiResponse;
import com.example.spring_homework002.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("")
    public ResponseEntity<?> getAllCourses() {
        courseService.getAllCourses();
        ApiResponse<?> apiResponse = ApiResponse.builder()
                .message("Get All Course Success")
                .payload(courseService.getAllCourses())
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable("id") Integer id) {
        courseService.getCourseById(id);
        ApiResponse<?> apiResponse = ApiResponse.builder()
                .message("Get Course  Success by Id: " + id)
                .payload(courseService.getCourseById(id))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourseById(@PathVariable("id") Integer id) {
        courseService.deleteCourseById(id);
        ApiResponse<?> apiResponse = ApiResponse.builder()
                .message("Delete Course  Success by Id: " + id)
                .payload(null)
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("")
    public ResponseEntity<?> addCourse(@RequestBody CourseRequest courseRequest) {
        ApiResponse<?> apiResponse = ApiResponse.builder()
                .message("Create Course Successfully")
                .payload(courseService.addCourse(courseRequest))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

}
