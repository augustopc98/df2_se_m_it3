package com.example.demo.service;

import com.example.demo.domain.CustomerOrder;
import com.example.demo.domain.OrderItem;

import java.util.List;

public interface CustomerOrderService {
    CustomerOrder createCustomerOrder(String customerEmail, String customerAddress, List<OrderItem> items);
    void addOrderItem(Long orderId, OrderItem item);
    void removeOrderItem(Long orderId, OrderItem item);
    void processCustomerOrderForDelivery(Long orderId);
    void updateCustomerOrderDeliveryStatus(Long orderId, String status);
    CustomerOrder getCustomerOrder(Long orderId);
    List<CustomerOrder> getOrdersByCustomer(String customerEmail);
}
