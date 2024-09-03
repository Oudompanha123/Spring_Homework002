package com.example.spring_homework002.service;

import com.example.spring_homework002.model.Instructor;
import com.example.spring_homework002.model.dto.request.InstructorRequest;
import com.example.spring_homework002.model.dto.response.InstructorResponse;
import com.example.spring_homework002.repository.InstructorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Primary
public class InstructorServiceImpl implements InstructorService{

    private final InstructorRepository instructorRepository;
    private final ModelMapper modelMapper;

    public InstructorServiceImpl(InstructorRepository instructorRepository, ModelMapper modelMapper) {
        this.instructorRepository = instructorRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<InstructorResponse> getAllInstructors() {
        List<Instructor> instructors = instructorRepository.getAllInstructors();
        List<InstructorResponse> instructorResponses = new ArrayList<>();
//        System.out.println("Get all from repo: " + instructors);
        for (Instructor instructor : instructors){
            InstructorResponse instructorResponse = modelMapper.map(instructor, InstructorResponse.class);
            instructorResponses.add(instructorResponse);
        }
        return instructorResponses;
    }

    @Override
    public InstructorResponse getInstructorById(Integer id) {
        Instructor instructor = instructorRepository.getInstructorById(id);
        return modelMapper.map(instructor, InstructorResponse.class);
    }

    @Override
    public InstructorResponse addInstructor(InstructorRequest instructorRequest) {
        Instructor instructor = instructorRepository.addInstructor(instructorRequest);
        System.out.println("Create from repo: " + instructor);
        return modelMapper.map(instructor, InstructorResponse.class);
    }

    @Override
    public Instructor deleteInstructorById(Integer id) {
        System.out.println("Instructor" + instructorRepository.deleteInstructorById(id));
        return instructorRepository.deleteInstructorById(id);
    }

    @Override
    public InstructorResponse updateInstructorById(Integer id, InstructorRequest instructorRequest) {
        Instructor instructor = instructorRepository.updateInstructorById(id, instructorRequest);
        System.out.println("Update Instructor by Id: " + instructor);
        return modelMapper.map(instructor, InstructorResponse.class);
    }
}
