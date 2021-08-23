package com.microservices.order.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
@Table(name = "order")
@EntityListeners(AuditingEntityListener.class)
public class Order extends BaseEntity {
    @Column(name = "order_number")
    private String orderNumber;

    @Column(name = "username")
    private String username;

    @Column(name = "total_amount")
    private Double totalAmount;

    @Column(name = "pay_amount")
    private Double payAmount;

    @Column(name = "freight_amount")
    private Double freightAmount;

    @Column(name = "integration_amount")
    private Double integrationAmount;

    @Column(name = "coupon_amount")
    private Double couponAmount;

    @Column(name = "pay_type")
    private Integer payType;

    @Column(name = "source_type")
    private Integer sourceType;

    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private OrderStatus status;

    @Column(name = "order_type")
    private Integer orderType;

    @Column(name = "confirm_status")
    private Integer confirmStatus;

    @Column(name = "delivery_number")
    private String deliveryNumber;

    @Column(name = "receiver_name")
    private String receiverName;

    @Column(name = "receiver_phone")
    private String receiverPhone;

    @Column(name = "receiver_detail_address")
    private String receiverDetailAddress;

    @Column(name = "payment_time")
    private Date paymentTime;

    @Column(name = "delivery_time")
    private Date deliveryTime;

    @Column(name = "receive_time")
    private Date receiveTime;

    @Transient
    private List<OrderItem> orderItems;
}

