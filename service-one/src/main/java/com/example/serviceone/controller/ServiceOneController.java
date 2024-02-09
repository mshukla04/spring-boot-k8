package com.example.serviceone.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1")
public class ServiceOneController {


    @GetMapping("/send1")
    public String getFromOtherService() {
        RestTemplate restTemplate = new RestTemplate();
        String endPoint = "http://service2-service:9090/api/v2/receive2";
        return restTemplate.getForObject(endPoint, String.class);
    }

    @GetMapping("/receive1")
    public String response(){
        return "Sending response from service 1";
    }
}
