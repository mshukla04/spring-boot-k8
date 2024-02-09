package com.example.serviceone.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/v1")
public class ServiceOneController {

    private final RestTemplate restTemplate;

    public ServiceOneController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/send1")
    public String getFromOtherService() throws URISyntaxException {
        String endPoint = "http://34.36.132.185/api/v2/receive2";
        String response = restTemplate.getForObject(endPoint, String.class);
        return response;
    }

    @GetMapping("/receive1")
    public String response(){
        return "Sending response from service 1";
    }
}
