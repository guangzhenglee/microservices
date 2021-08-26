package com.microservices.product.client;

import com.microservices.product.client.configuration.IntegrationFeignClientConfiguration;
import com.microservices.product.client.configuration.IntegrationFeignClientErrorDecoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "integrationFeignClient", url = "${service.integration.url}", configuration = {IntegrationFeignClientConfiguration.class, IntegrationFeignClientErrorDecoder.class})
public interface IntegrationFeignClient {
    @GetMapping(value = "/api/v1/feign-test/read-timeout")
    Boolean readTimeout();

    @GetMapping(value = "/api/v1/feign-test/header-auth")
    Boolean headerAuth();

    @GetMapping(value = "/api/v1/feign-test/exception")
    Boolean throwException();
}
