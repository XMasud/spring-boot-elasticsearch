package com.example.elasticsearch.service;

import com.example.elasticsearch.entity.Product;
import com.example.elasticsearch.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public Iterable<Product> getAllProduct(){
        return productRepository.findAll();
    }

    public Product updateProduct(Product product, int id){
        Product existingProduct =  productRepository.findById(id).get();
        existingProduct.setDescription(product.getDescription());
        return product;
    }

    public void deleteProduct(int id){
        productRepository.deleteById(id);
    }

}
