package com.example.spring_homework002.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class Product {
    private Long id;

    private String name;

    private BigDecimal price;

    //@Column(columnDefinition = "jsonb")
    private Map<String, Object> specifications; // JSONB field

    private Boolean inStock;

    public Product(Long id, String name, BigDecimal price, Map<String, Object> specifications, Boolean inStock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.specifications = specifications;
        this.inStock = inStock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", specifications=" + specifications +
                ", inStock=" + inStock +
                '}';
    }
}
