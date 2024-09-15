package com.example.spring_homework002.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class Student {
    private Integer studentId;
    private String studentName;
    private String email;
    private String phoneNumber;
    private List<Course> courses;

    public Student(Integer studentId, String studentName, String email, String phoneNumber, List<Course> courses) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", courses=" + courses +
                '}';
    }
}
