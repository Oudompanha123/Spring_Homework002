package com.example.spring_homework002.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Instructor {
    private Integer instructorId;
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

