package com.example.spring_homework002.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@JsonPropertyOrder({"instructor_id", "instructor_name", "email"})
public class InstructorResponse {
    @JsonProperty("instructor_id")
    private Integer instructorId;
    @JsonProperty("instructor_name")
    private String instructorName;
    private String email;

    public InstructorResponse(Integer instructorId, String instructorName, String email) {
        this.instructorId = instructorId;
        this.instructorName = instructorName;
        this.email = email;
    }
}
