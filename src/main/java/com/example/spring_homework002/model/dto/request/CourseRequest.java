package com.example.spring_homework002.model.dto.request;

import com.example.spring_homework002.model.Instructor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"course_name", "description" ,"instructor_id"})
public class CourseRequest {
    @JsonProperty("course_name")
    private String courseName;
    private String description;
    @JsonProperty("instructor_id")
    private Integer instructorId;
}
