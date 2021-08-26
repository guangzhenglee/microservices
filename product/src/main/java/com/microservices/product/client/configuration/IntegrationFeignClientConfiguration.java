package com.microservices.product.client.configuration;

import feign.RequestInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.StandardCharsets;

import static java.util.Objects.nonNull;

@Configuration
@Slf4j
public class IntegrationFeignClientConfiguration {
    @Bean
    public RequestInterceptor requestInterceptor(){
        return requestTemplate -> {
            log.info("integration client url:{}", requestTemplate.url());
            if (nonNull(requestTemplate.body())) {
                String body = new String(requestTemplate.body(), StandardCharsets.UTF_8);
                log.info("dmp request body: \n{}", body);
            }
            requestTemplate.header("token", "test_token");
        };
    }
}
