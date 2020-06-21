package com.vote.vote.db.customSelect;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public interface OrderInterface {
    Integer product_id();
    String name();
    Integer sum();
    Integer one();
    Integer two();
    Integer three();
    Integer four();
    Integer five();
}