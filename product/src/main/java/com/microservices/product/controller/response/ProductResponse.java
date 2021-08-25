package com.microservices.product.controller.response;

import com.microservices.product.entity.Product;
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

    public static ProductResponse fromProduct(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .categoryId(product.getCategoryId())
                .name(product.getName())
                .productNumber(product.getProductNumber())
                .deleteStatus(product.getDeleteStatus())
                .publishStatus(product.getPublishStatus())
                .description(product.getDescription())
                .price(product.getPrice())
                .unit(product.getUnit())
                .createTime(product.getCreateTime())
                .updatedTime(product.getUpdatedTime())
                .build();
    }
}

