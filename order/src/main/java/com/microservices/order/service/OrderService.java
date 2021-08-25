package com.microservices.order.service;

import com.microservices.order.client.ProductClient;
import com.microservices.order.client.response.ProductResponse;
import com.microservices.order.client.response.SkuStockResponse;
import com.microservices.order.controller.request.CreateOrderRequest;
import com.microservices.order.entity.Order;
import com.microservices.order.entity.OrderItem;
import com.microservices.order.entity.OrderStatus;
import com.microservices.order.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderItemService orderItemService;
    private final ProductClient productClient;

    public void createOrder(CreateOrderRequest createOrderRequest) {
        List<OrderItem> orderItems = createOrderRequest.getOrderItems().stream()
                .map(it -> getOrderItem(it.getProductId(), it.getPurchaseQuantity()))
                .collect(toList());
        Double payAmount = orderItems.stream()
                .mapToDouble(orderItem -> orderItem.getProductPrice() * orderItem.getPurchaseQuantity())
                .sum();
        Order order = Order.builder()
                .orderNumber(UUID.randomUUID().toString()).orderType(0).confirmStatus(0)
                .couponAmount(0.0).freightAmount(0.0).integrationAmount(0.0)
                .payAmount(payAmount).paymentTime(new Date()).payType(0)
                .receiverDetailAddress("EU").receiverName("mike").receiverPhone("120")
                .sourceType(0).status(OrderStatus.PAYMENT_PENDING).totalAmount(payAmount)
                .username("username").build();
        Order savedOrder = orderRepository.saveAndFlush(order);
        orderItems.forEach(orderItem -> orderItem.setOrderId(savedOrder.getId()));
        orderItemService.saveOrderItemList(orderItems);
    }

    public Order getOrder(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("order not exist"));
    }

    private OrderItem getOrderItem(Long productId, Integer purchaseQuantity) {
        ProductResponse productResponse = productClient.getProduct(productId);
        SkuStockResponse skuStockResponse = productClient.getSkuStock(productId);
        return OrderItem.builder()
                .productId(productId)
                .productName(productResponse.getName())
                .productNumber(productResponse.getProductNumber())
                .productPrice(productResponse.getPrice())
                .purchaseQuantity(purchaseQuantity)
                .productSkuId(skuStockResponse.getId())
                .productSkuCode(skuStockResponse.getSkuCode())
                .build();
    }
}
