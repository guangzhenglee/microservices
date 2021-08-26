package com.microservices.product.controller;

import com.microservices.product.client.IntegrationFeignClient;
import com.microservices.product.client.IntegrationResilienceClient;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/integrations")
@AllArgsConstructor
public class IntegrationController {
    private final IntegrationFeignClient integrationFeignClient;
    private final IntegrationResilienceClient integrationResilienceClient;

    @GetMapping("/test-read-timeout")
    public boolean testReadTimeout() {
        return integrationFeignClient.readTimeout();
    }

    @GetMapping("/test-header-auth")
    public boolean testHeaderAuth() {
        return integrationFeignClient.headerAuth();
    }

    @GetMapping("/circuit-breaker")
    public boolean circuitBreaker(){
        return integrationResilienceClient.circuitBreaker();
    }

    @GetMapping("/slow-circuit-breaker")
    public boolean slowCircuitBreaker() {
        return integrationResilienceClient.slowCircuitBreaker();
    }
}
