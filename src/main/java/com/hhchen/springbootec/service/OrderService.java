package com.hhchen.springbootec.service;

import com.hhchen.springbootec.dto.CreateOrderRequest;
import com.hhchen.springbootec.model.Order;

public interface OrderService {

    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}

