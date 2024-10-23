package com.example.spring_homework002.service;

import com.example.spring_homework002.model.Product;
import com.example.spring_homework002.model.dto.request.ProductRequest;
import com.example.spring_homework002.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        System.out.println(productRepository.getAllProducts());
        return productRepository.getAllProducts();
    }
    @Override
    public Product createProduct(ProductRequest productRequest) {
        System.out.println("Create product: " + productRequest);
        System.out.println("Get new product: " + productRepository.createProduct(productRequest));
        return productRepository.createProduct(productRequest);
    }
}
