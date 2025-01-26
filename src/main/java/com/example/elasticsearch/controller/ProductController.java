package com.example.elasticsearch.controller;

import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.example.elasticsearch.entity.Product;
import com.example.elasticsearch.service.ProductService;
import com.example.elasticsearch.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
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
    Iterable<Product> findAllProduct() {
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
    public List<Product> matchProducts() throws IOException {
        SearchResponse<Product> searchResponse = searchService.matchAllServices();
        List<Hit<Product>> listOfHits = searchResponse.hits().hits();
        List<Product> productList = new ArrayList<>();

        for (Hit<Product> hit : listOfHits) {
            productList.add(hit.source());
        }
        return productList;
    }
}
