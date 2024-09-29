package com.example.spring_homework002.model.dto.request;

import com.example.spring_homework002.model.Course;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class StudentRequest {
    private String studentName;
    private String email;
    private String phoneNumber;
    private List<Integer> courseId;

    public StudentRequest(String studentName, String email, String phoneNumber, List<Integer> courseId) {
        this.studentName = studentName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.courseId = courseId;
    }
}
