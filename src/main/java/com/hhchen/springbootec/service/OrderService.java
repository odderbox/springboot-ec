package com.hhchen.springbootec.service;

import com.hhchen.springbootec.dto.CreateOrderRequest;
import com.hhchen.springbootec.dto.OrderQueryParams;
import com.hhchen.springbootec.model.Order;

import java.util.List;

public interface OrderService {

    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    Integer countOrder(OrderQueryParams orderQueryParams);
}

