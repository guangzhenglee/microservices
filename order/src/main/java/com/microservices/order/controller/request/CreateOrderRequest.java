package com.microservices.order.controller.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateOrderRequest {
    private String username;

    private Integer payType;

    private Integer sourceType;

    private Integer orderType;

    private String receiverName;

    private String receiverPhone;

    private String receiverDetailAddress;

    private List<OrderItemRequest> orderItems;
}
