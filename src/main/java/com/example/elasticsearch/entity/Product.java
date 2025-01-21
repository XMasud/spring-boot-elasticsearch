package com.example.elasticsearch.entity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private String description;
    private int quantity;
    private double price;
}
