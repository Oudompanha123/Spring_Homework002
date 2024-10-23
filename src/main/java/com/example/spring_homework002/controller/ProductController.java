package com.example.spring_homework002.controller;

import com.example.spring_homework002.model.Product;
import com.example.spring_homework002.model.dto.response.ApiResponse;
import com.example.spring_homework002.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("")
    public ResponseEntity<?> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        ApiResponse<?> response = ApiResponse.builder()
                .message("Get all products")
                .payload(products)
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }
}
