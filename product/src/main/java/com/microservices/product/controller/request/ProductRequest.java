package com.microservices.product.controller.request;

import com.microservices.product.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ProductRequest {

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

    public Product toProduct() {
        return Product.builder()
                .categoryId(categoryId)
                .name(name)
                .productNumber(productNumber)
                .deleteStatus(deleteStatus)
                .publishStatus(publishStatus)
                .description(description)
                .price(price)
                .unit(unit)
                .createTime(createTime)
                .updatedTime(updatedTime)
                .build();
    }
}

