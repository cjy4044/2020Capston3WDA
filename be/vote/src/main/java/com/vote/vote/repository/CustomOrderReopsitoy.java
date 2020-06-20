package com.vote.vote.repository;

import java.util.List;

import com.vote.vote.db.customSelect.CustomOrderState;

public interface CustomOrderReopsitoy {
    List<CustomOrderState> getOrderStateByManagerId(int managerId);
}