package com.example.spring_homework002.repository;

import com.example.spring_homework002.config.ListJsonbTypeHandler;
import com.example.spring_homework002.model.Product;
import com.example.spring_homework002.model.dto.request.ProductRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductRepository {

    @Select("""
            SELECT * FROM product
            """)
    @Results(id = "productMapping", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "price", column = "price"),
            @Result(property = "specifications", column = "specifications", typeHandler = ListJsonbTypeHandler.class),
            @Result(property = "inStock", column = "in_stock")
    })
    List<Product> getAllProducts();

    @Select("""
            INSERT INTO product (name, price, specifications, in_stock)
                VALUES (#{product.name}, #{product.price}, #{product.specifications}, #{product.inStock}) RETURNING *;
            """)
    @ResultMap("productMapping")
    Product createProduct(@Param("product") ProductRequest productRequest);
}
