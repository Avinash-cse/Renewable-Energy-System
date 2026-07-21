package com.skillfirstlab.apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GatewayController {

    private final RestTemplate restTemplate;

    public GatewayController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/")
    public String home() {
        return "Renewable Energy API Gateway Running";
    }

    @GetMapping("/final")
    public String finalOutput() {

        return restTemplate.getForObject(
                "http://localhost:8084/distribution/generate",
                String.class);

    }

}