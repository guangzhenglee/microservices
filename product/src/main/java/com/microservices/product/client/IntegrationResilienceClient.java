package com.microservices.product.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "integrationResilienceClient", url = "${service.integration.url}")
public interface IntegrationResilienceClient {
    @GetMapping(value = "/api/v1/resilience-test/circuit-breaker")
    Boolean circuitBreaker();

    @GetMapping(value = "/api/v1/resilience-test/slow-circuit-breaker")
    Boolean slowCircuitBreaker();
}
