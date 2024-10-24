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
        System.out.println(productRepository.getAllProducts());
        return productRepository.getAllProducts();
    }
    @Override
    public Product createProduct(ProductRequest productRequest) {
        System.out.println("Get new product: " + productRepository.createProduct(productRequest));
        ProductRequest productRequest1 = new ProductRequest();
        productRequest1.setName("Wireless Mouse");
        productRequest1.setPrice(new BigDecimal("29.99"));
        productRequest1.setSpecifications(List.of(
                Map.of("color", "black", "batteryLife", "12 months", "connectionType", "Bluetooth")
        ));
        productRequest1.setInStock(true);
        System.out.println("Create product: " + productRequest1);
        return null;
        //return productRepository.createProduct(productRequest1);
    }
}
