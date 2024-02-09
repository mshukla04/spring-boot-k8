package com.example.serviceone.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

@RestController
@RequestMapping("/api/v1")
public class ServiceOneController {

    private final RestTemplate restTemplate;

    public ServiceOneController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/send1")
    public String getFromOtherService() throws IOException {
//        URI uri = new URI("http://service2-service:9090/api/v2/receive2");
        String endPoint = "https://jsonplaceholder.typicode.com/posts";
        URL url = new URL(endPoint);

        // Open connection
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Set request method (GET, POST, etc.)
        connection.setRequestMethod("GET");

        // Get response code
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        // Read response
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        StringBuffer response = new StringBuffer();

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        // Print response
        System.out.println("Response: " + response.toString());

        // Close connection
        connection.disconnect();

        return response.toString();
    }

    @GetMapping("/receive1")
    public String response(){
        return "Sending response from service 1";
    }
}
