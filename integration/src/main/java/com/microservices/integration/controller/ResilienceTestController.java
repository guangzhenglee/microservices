package com.microservices.integration.controller;

import com.microservices.integration.exception.IntegrationException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/resilience-test")
@Slf4j
public class ResilienceTestController {
    @GetMapping("/slow-circuit-breaker")
    public boolean slowCircuitBreaker() throws InterruptedException {
        int rate = RandomUtils.nextInt(0, 10);
        if (rate > 5) {
            log.info("slowCircuitBreaker");
            return true;
        } else {
            Thread.sleep(20000);
        }
        log.info("slowCircuitBreaker");
        return true;
    }

    @GetMapping("/circuit-breaker")
    public boolean circuitBreaker() {
        log.info("circuitBreaker");
        boolean isSuccess = RandomUtils.nextBoolean();
        if (isSuccess) {
            return true;
        } else {
            throw new IntegrationException("circuitBreaker fail");
        }
    }
}
