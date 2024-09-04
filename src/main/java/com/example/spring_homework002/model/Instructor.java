package com.example.spring_homework002.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonPropertyOrder({"instructor_id", "instructor_name", "email"})
public class Instructor {
    @JsonProperty("instructor_id")
    private Integer instructorId;
    @JsonProperty("instructor_name")
    private String instructorName;
    private String email;

    public Instructor(Integer instructorId, String instructorName, String email) {
        this.instructorId = instructorId;
        this.instructorName = instructorName;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "instructorId=" + instructorId +
                ", instructorName='" + instructorName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

