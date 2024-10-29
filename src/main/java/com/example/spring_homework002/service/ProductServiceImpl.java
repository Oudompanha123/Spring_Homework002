package com.example.spring_homework002.service;

import com.example.spring_homework002.model.Product;
import com.example.spring_homework002.model.dto.request.ProductRequest;
import com.example.spring_homework002.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }
    @Override
    public void createProduct(ProductRequest productRequest) {
        productRepository.createProduct(productRequest);
    }
}
