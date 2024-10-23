package com.example.spring_homework002.repository;

import com.example.spring_homework002.config.ListJsonbTypeHandler;
import com.example.spring_homework002.model.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

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
}
