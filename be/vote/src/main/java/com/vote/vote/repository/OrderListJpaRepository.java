package com.vote.vote.repository;

import com.vote.vote.db.dto.OrderList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderListJpaRepository extends JpaRepository<OrderList, Integer>{
    
}