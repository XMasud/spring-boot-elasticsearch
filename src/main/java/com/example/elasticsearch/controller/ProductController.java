package com.example.elasticsearch.controller;

import co.elastic.clients.elasticsearch.core.SearchResponse;
import com.example.elasticsearch.entity.Product;
import com.example.elasticsearch.service.ProductService;
import com.example.elasticsearch.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private SearchService searchService;

    @GetMapping
    Iterable<Product> findAllProduct(){
        return productService.getAllProduct();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping("/{name}")
    public List<Product> getProductsByName(@PathVariable String name) {
        return productService.findByName(name);
    }

    @GetMapping("/match")
    String match() throws IOException {
        SearchResponse<Map>  searchResponse = searchService.matchAllServices();
        return searchResponse.hits().hits().toString();
    }
}
