package com.example.spring_homework002.service;

import com.example.spring_homework002.model.Course;
import com.example.spring_homework002.model.dto.request.CourseRequest;
import com.example.spring_homework002.model.dto.response.CourseResponse;
import com.example.spring_homework002.repository.CourseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    private final CourseRepository courseRepository;
    private  final ModelMapper modelMapper;

    public CourseServiceImpl(CourseRepository courseRepository, ModelMapper modelMapper) {
        this.courseRepository = courseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CourseResponse> getAllCourses() {
        courseRepository.findAll();
        //System.out.println("All Course: " + courseRepository.findAll());
        List<Course> courses = courseRepository.findAll();
        List<CourseResponse> courseResponses = new ArrayList<>();
        for (Course course : courses) {
            CourseResponse courseResponse = modelMapper.map(course, CourseResponse.class);
            courseResponses.add(courseResponse);

        }
        return courseResponses;
    }
    @Override
    public CourseResponse getCourseById(Integer id) {
        Course course = courseRepository.findById(id);
        return modelMapper.map(course, CourseResponse.class);
    }

    @Override
    public void deleteCourseById(Integer id) {
        courseRepository.deleteCourseById(id);
    }

    @Override
    public CourseResponse addCourse(CourseRequest courseRequest) {
        courseRepository.addCourse(courseRequest);
        Course course = courseRepository.addCourse(courseRequest);
        System.out.println("Course added " + course);
        return modelMapper.map(course, CourseResponse.class);
    }

}
