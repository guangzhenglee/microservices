package com.microservices.product.controller.request;

import com.microservices.product.entity.SkuStock;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SkuStockRequest {
    private Long productId;

    private String skuCode;

    private Integer stock;

    private Integer lowStock;

    private Integer sale;

    private Integer lockStock;

    private Date createTime;

    private Date updatedTime;

    public SkuStock toSkuStock() {
        return SkuStock.builder()
                .productId(productId)
                .skuCode(skuCode)
                .stock(stock)
                .lowStock(lowStock)
                .sale(sale)
                .lockStock(lockStock)
                .createTime(createTime)
                .updatedTime(updatedTime)
                .build();
    }
}
