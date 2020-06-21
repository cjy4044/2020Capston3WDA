package com.vote.vote.repository;

import java.util.List;

import com.vote.vote.db.customSelect.CustomOrderState;
import com.vote.vote.db.customSelect.CustomPrdRecommend;

public interface CustomOrderReopsitoy {
    List<CustomOrderState> getOrderStateByManagerId(int managerId);

}