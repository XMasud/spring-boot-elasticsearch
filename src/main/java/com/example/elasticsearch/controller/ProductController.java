package com.example.elasticsearch.controller;

import com.example.elasticsearch.entity.Product;
import com.example.elasticsearch.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    Iterable<Product> findAllProduct(){
        return productService.getAllProduct();
    }
}
