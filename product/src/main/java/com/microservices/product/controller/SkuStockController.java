package com.microservices.product.controller;

import com.microservices.product.controller.request.SkuStockRequest;
import com.microservices.product.controller.response.SkuStockResponse;
import com.microservices.product.service.SkuStockService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/stock")
public class SkuStockController {
    private final SkuStockService skuStockService;

    @PostMapping
    public void createSkuStock(@RequestBody SkuStockRequest skuStockRequest) {
        skuStockService.createSkuStock(skuStockRequest.toSkuStock());
    }

    @GetMapping(value = "/{productId}")
    public SkuStockResponse getSkuStock(@PathVariable("productId") Long productId) {
        return SkuStockResponse.fromSkuStock(skuStockService.getSkuStock(productId));
    }
}
