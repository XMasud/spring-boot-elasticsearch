package com.example.elasticsearch.service;

import com.example.elasticsearch.entity.Product;
import com.example.elasticsearch.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

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
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }
    public void deleteProduct(int id){
        productRepository.deleteById(id);
    }
}
