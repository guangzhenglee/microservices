package com.microservices.order.client.response;

import lombok.Data;

import java.util.Date;

@Data
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
}
