package com.microservices.order.client.response;

import lombok.Data;

import java.util.Date;

@Data
public class ProductResponse {
    private Long id;

    private Long categoryId;

    private String name;

    private String productNumber;

    private Integer deleteStatus;

    private Integer publishStatus;

    private Double price;

    private String description;

    private String unit;

    private Date createTime;

    private Date updatedTime;
}

