package com.example.serviceone.controller;

import com.example.serviceone.entity.Product;
import com.example.serviceone.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ServiceOneController {

    private final ProductService productService;

    public ServiceOneController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/send1")
    public String getFromOtherService() {
        RestTemplate restTemplate = new RestTemplate();
        String endPoint = "http://service2-service:9090/api/v2/receive2";
        return restTemplate.getForObject(endPoint, String.class);
    }

    @GetMapping("/receive1")
    public List<Product> response(){
        return this.productService.getAllProduct();
    }
}
