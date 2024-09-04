package com.example.spring_homework002.model.dto.response;

import com.example.spring_homework002.model.Instructor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@JsonPropertyOrder({"course_id", "course_name"})
public class CourseResponse {
    @JsonProperty("course_id")
    private Integer courseId;
    @JsonProperty("course_name")
    private String courseName;
    private String description;
    private Instructor instructor;

    public CourseResponse(Integer courseId, String courseName, String description, Instructor instructor) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.description = description;
        this.instructor = instructor;
    }
}
