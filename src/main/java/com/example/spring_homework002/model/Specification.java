package com.example.spring_homework002.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;
@Data
@RequiredArgsConstructor
public class Specification {
    private Map<String, Object> specification;

    @Override
    public String toString() {
        return "Specification{" +
                "specification=" + specification +
                '}';
    }
}
