package com.example.spring_homework002.service;

import com.example.spring_homework002.model.dto.request.CourseRequest;
import com.example.spring_homework002.model.dto.response.CourseResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CourseService {

    List<CourseResponse> getAllCourses();

    CourseResponse getCourseById(Integer id);

    void deleteCourseById(Integer id);

    CourseResponse addCourse(CourseRequest courseRequest);

    CourseResponse updateCourseById(Integer id, CourseRequest courseRequest);
}
