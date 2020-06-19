package com.vote.vote.repository;

import com.vote.vote.db.customSelect.CustomOrderListSelect;

import org.springframework.data.domain.Pageable;

public interface CustomOrderListRepository {
    CustomOrderListSelect getOrderListbyUserId(int r_id, Pageable page); // 유저 id 로 주문 내역 검색

    CustomOrderListSelect getOrderListbyOrderId(int orderId); // 주문 id 로 주문내역 검색.

}