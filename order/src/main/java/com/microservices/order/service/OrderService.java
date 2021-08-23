package com.microservices.order.service;

import com.microservices.order.repository.OrderItemRepository;
import com.microservices.order.repository.OrderOperateHistoryRepository;
import com.microservices.order.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final OrderOperateHistoryRepository orderOperateHistoryRepository;

}
