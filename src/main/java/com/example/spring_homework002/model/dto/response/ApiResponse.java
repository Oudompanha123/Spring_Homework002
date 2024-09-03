package com.example.spring_homework002.model.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class ApiResponse <T>{
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T payload;
    private HttpStatus status;
    private LocalDateTime time;

    public ApiResponse(String message, T payload, HttpStatus status, LocalDateTime time) {
        this.message = message;
        this.payload = payload;
        this.status = status;
        this.time = time;
    }
}
