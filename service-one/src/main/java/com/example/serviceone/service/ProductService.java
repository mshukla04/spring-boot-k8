package com.example.serviceone.service;

import com.example.serviceone.entity.Product;
import com.example.serviceone.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProduct(){
        return this.productRepository.findAll();
    }
}
