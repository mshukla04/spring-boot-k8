package com.example.servicetwo.controller;

import com.example.servicetwo.entity.Customer;
import com.example.servicetwo.service.CustomerService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v2")
public class ServiceTwoController {

    private final CustomerService customerService;

    public ServiceTwoController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/send2")
    public String getFromOtherService() {
        RestTemplate restTemplate = new RestTemplate();
        String endPoint = "http://service1-service.default.svc.cluster.local:8080/api/v1/receive1";
        return restTemplate.getForObject(endPoint, String.class);
    }

    @GetMapping("/receive2")
    public void response(){
        this.customerService.getAll();
    }

}
