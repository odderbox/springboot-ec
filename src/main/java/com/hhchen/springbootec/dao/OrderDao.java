package com.hhchen.springbootec.dao;

import com.hhchen.springbootec.model.OrderItem;

import java.util.List;

public interface  OrderDao {
    Integer createOrder(Integer userId, Integer totalAmount);

    void createOrderItems(Integer orderId, List<OrderItem> orderItemList);
}
