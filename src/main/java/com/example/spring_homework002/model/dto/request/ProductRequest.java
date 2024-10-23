package com.example.spring_homework002.model.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class ProductRequest {
    private String name;

    private BigDecimal price;

    private List<Map<String, Object>> specifications; // JSONB field

    private Boolean inStock;

    public ProductRequest(String name, BigDecimal price, List<Map<String, Object>> specifications, Boolean inStock) {
        this.name = name;
        this.price = price;
        this.specifications = specifications;
        this.inStock = inStock;
    }

    @Override
    public String toString() {
        return "ProductRequest{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", specifications=" + specifications +
                ", inStock=" + inStock +
                '}';
    }
}