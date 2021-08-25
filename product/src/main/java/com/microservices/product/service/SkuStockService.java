package com.microservices.product.service;

import com.microservices.product.repository.SkuStockRepository;
import com.microservices.product.entity.SkuStock;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SkuStockService {
    private final SkuStockRepository skuStockRepository;

    public SkuStock getSkuStock(Long productId) {
        return skuStockRepository.findByProductId(productId)
                .orElseThrow(() ->  new RuntimeException("sku stock not exist"));
    }

    public void createSkuStock(SkuStock skuStock) {
        skuStockRepository.saveAndFlush(skuStock);
    }
}
