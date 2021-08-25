package com.microservices.product.controller.response;

import com.microservices.product.entity.SkuStock;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SkuStockResponse {
    private Long id;

    private Long productId;

    private String skuCode;

    private Integer stock;

    private Integer lowStock;

    private Integer sale;

    private Integer lockStock;

    private Date createTime;

    private Date updatedTime;

    public static SkuStockResponse fromSkuStock(SkuStock skuStock) {
        return SkuStockResponse.builder()
                .productId(skuStock.getProductId())
                .skuCode(skuStock.getSkuCode())
                .stock(skuStock.getStock())
                .lowStock(skuStock.getLowStock())
                .sale(skuStock.getSale())
                .lockStock(skuStock.getLockStock())
                .createTime(skuStock.getCreateTime())
                .updatedTime(skuStock.getUpdatedTime())
                .build();
    }
}
