package com.example.spring_homework002.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Course {
    private Integer courseId;
    private String courseName;
    private String description;
    private Instructor instructor;

    public Course(Integer courseId, String courseName, String description, Instructor instructor) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.description = description;
        this.instructor = instructor;
    }
}
