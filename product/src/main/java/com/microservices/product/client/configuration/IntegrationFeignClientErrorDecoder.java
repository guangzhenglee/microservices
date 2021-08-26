package com.microservices.product.client.configuration;

import com.microservices.product.exception.IntegrationException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IntegrationFeignClientErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        try {
            log.info("Integration feign client get error response, request={}, response={}",
                    response.request().toString(), response.toString());
            return new IntegrationException(response.body().toString());
        } catch (Exception e) {
            log.error("try handle client error but get a exception", e);
            return new IntegrationException("try handle client error but get a exception");
        }
    }
}
