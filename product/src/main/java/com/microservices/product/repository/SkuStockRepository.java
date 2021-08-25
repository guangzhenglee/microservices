package com.microservices.product.repository;

import com.microservices.product.entity.SkuStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkuStockRepository extends JpaRepository<SkuStock, Long> {
    Optional<SkuStock> findByProductId(Long productId);
}
