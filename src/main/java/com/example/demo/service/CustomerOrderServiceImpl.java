package com.example.demo.service;

import com.example.demo.domain.CustomerOrder;
import com.example.demo.domain.OrderItem;
import com.example.demo.repository.CustomerOrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    private final CustomerOrderRepository repository;

    public CustomerOrderServiceImpl(CustomerOrderRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public CustomerOrder createCustomerOrder(String customerEmail, String customerAddress, List<OrderItem> items) {
        CustomerOrder order = new CustomerOrder(customerEmail, customerAddress, new java.util.Date());
        items.forEach(order::addOrderItem);
        return repository.save(order);
    }

    @Override
    public void addOrderItem(Long orderId, OrderItem item) {
        CustomerOrder order = getCustomerOrder(orderId);
        order.addOrderItem(item);
        repository.save(order);
    }

    @Override
    public void removeOrderItem(Long orderId, OrderItem item) {
        CustomerOrder order = getCustomerOrder(orderId);
        order.removeOrderItem(item);
        repository.save(order);
    }

    @Override
    public void processCustomerOrderForDelivery(Long orderId) {
        CustomerOrder order = getCustomerOrder(orderId);
        order.sendForDelivery();
        repository.save(order);
    }

    @Override
    public void updateCustomerOrderDeliveryStatus(Long orderId, String status) {
        CustomerOrder order = getCustomerOrder(orderId);
        order.updateDeliveryStatus(status);
        repository.save(order);
    }

    @Override
    public CustomerOrder getCustomerOrder(Long orderId) {
        return repository.findById(orderId).orElseThrow(() -> new RuntimeException("CustomerOrder Not Found"));
    }

    @Override
    public List<CustomerOrder> getOrdersByCustomer(String customerEmail) {
        return repository.findByCustomerEmail(customerEmail);
    }
}
