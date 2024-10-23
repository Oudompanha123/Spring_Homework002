package com.example.spring_homework002.service;

import com.example.spring_homework002.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService{
    List<Product> getAllProducts();
}
