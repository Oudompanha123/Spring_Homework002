package com.example.spring_homework002.service;

import com.example.spring_homework002.model.Instructor;
import com.example.spring_homework002.model.dto.request.InstructorRequest;
import com.example.spring_homework002.model.dto.response.InstructorResponse;
import org.apache.commons.lang3.ClassUtils;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

public interface InstructorService {

    List<InstructorResponse> getAllInstructors();

    InstructorResponse getInstructorById(Integer id);

    InstructorResponse addInstructor(InstructorRequest instructorRequest);

    Instructor deleteInstructorById(Integer id);

    InstructorResponse updateInstructorById(Integer id, InstructorRequest instructorRequest);
}
