package com.example.spring_homework002.service;

import com.example.spring_homework002.model.Product;
import com.example.spring_homework002.model.dto.request.ProductRequest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService{
    List<Product> getAllProducts();

    void createProduct(ProductRequest productRequest);
}
