package com.example.spring_homework002.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
@Data
@NoArgsConstructor
public class Specification {
    private BigInteger code;
    private String description;

    public Specification(BigInteger code, String description) {
        this.code = code;
        this.description = description;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
