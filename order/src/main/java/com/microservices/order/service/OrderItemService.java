package com.microservices.order.service;

import com.microservices.order.entity.OrderItem;
import com.microservices.order.repository.OrderItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;

    public void saveOrderItemList(List<OrderItem> orderItems) {
        orderItemRepository.saveAll(orderItems);
    }
}
