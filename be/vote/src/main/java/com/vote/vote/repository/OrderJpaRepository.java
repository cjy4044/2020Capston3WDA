package com.vote.vote.repository;

import com.vote.vote.db.dto.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJpaRepository extends JpaRepository<Order, Integer> {
    public Order findByOrderId(int orderId);
}