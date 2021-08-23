package com.microservices.order.entity;

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
@Table(name = "order_operate_history")
@EntityListeners(AuditingEntityListener.class)
public class OrderOperateHistory extends BaseEntity {
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "operate_name")
    private String operateName;

    @Column(name = "order_status")
    private Integer orderStatus;
}
