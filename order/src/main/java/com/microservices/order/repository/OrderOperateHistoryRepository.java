package com.microservices.order.repository;

import com.microservices.order.entity.OrderOperateHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderOperateHistoryRepository extends JpaRepository<OrderOperateHistory, Long> {
}
