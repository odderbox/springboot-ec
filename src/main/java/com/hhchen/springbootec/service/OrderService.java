package com.hhchen.springbootec.service;

import com.hhchen.springbootec.dto.CreateOrderRequest;

public interface OrderService {

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}

