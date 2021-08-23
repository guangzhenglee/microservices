package com.mircoservices.product.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
@Table(name = "sku_stock")
@EntityListeners(AuditingEntityListener.class)
public class SkuStock extends BaseEntity {
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "sku_code")
    private String skuCode;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "low_stock")
    private Integer lowStock;

    @Column(name = "sale")
    private Integer sale;

    @Column(name = "lock_stock")
    private Integer lockStock;
}
