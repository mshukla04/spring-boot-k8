package com.example.servicetwo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v2")
public class ServiceTwoController {

    private final RestTemplate restTemplate;

    public ServiceTwoController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/send2")
    public String getFromOtherService() {
        String endPoint = "http://service1-service.default.svc.cluster.local:8080/api/v1/receive1";
        return restTemplate.getForObject(endPoint, String.class);
    }

    @GetMapping("/receive2")
    public String response(){
        return "Sending response from service 2";
    }
}
