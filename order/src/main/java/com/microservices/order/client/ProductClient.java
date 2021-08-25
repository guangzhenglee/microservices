package com.microservices.order.client;

import com.microservices.order.client.response.ProductResponse;
import com.microservices.order.client.response.SkuStockResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "productClient", url = "${service.product.url}")
public interface ProductClient {
    @GetMapping(value = "/api/v1/products/{productId}")
    ProductResponse getProduct(@PathVariable("productId") Long productId);

    @GetMapping(value = "/api/v1/stock/{productId}")
    SkuStockResponse getSkuStock(@PathVariable("productId") Long productId);
}
