package com.hhchen.springbootec.dao;

import com.hhchen.springbootec.dto.OrderQueryParams;
import com.hhchen.springbootec.model.Order;
import com.hhchen.springbootec.model.OrderItem;

import java.util.List;

public interface  OrderDao {

    Order getOrderById(Integer orderId);

    List<OrderItem> getOrderItemByOrderId(Integer orderId);

    Integer createOrder(Integer userId, Integer totalAmount);

    void createOrderItems(Integer orderId, List<OrderItem> orderItemList);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    Integer countOrder(OrderQueryParams orderQueryParams);

}
