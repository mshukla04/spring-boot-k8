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
//        URI uri = new URI("http://service2-service:9090/api/v2/receive2");
        String endPoint = "https://jsonplaceholder.typicode.com/posts";
        return restTemplate.getForObject(endPoint, String.class);
    }

    @GetMapping("/receive1")
    public String response(){
        return "Sending response from service 1";
    }
}
