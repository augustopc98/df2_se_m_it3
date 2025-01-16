package com.example.demo.controller;

import com.example.demo.domain.CustomerOrder;
import com.example.demo.domain.OrderItem;
import com.example.demo.service.CustomerOrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customerorders")
public class CustomerOrderController {

    private final CustomerOrderService service;

    public CustomerOrderController(CustomerOrderService service) {
        this.service = service;
    }

    @PostMapping
    public CustomerOrder createCustomerOrder(@RequestBody CreateCustomerOrderRequest request) {
        return service.createCustomerOrder(request.getCustomerEmail(), request.getCustomerAddress(), request.getItems());
    }

    @GetMapping("/{orderId}")
    public CustomerOrder getCustomerOrder(@PathVariable Long orderId) {
        return service.getCustomerOrder(orderId);
    }

    @PostMapping("/{orderId}/items")
    public void addOrderItem(@PathVariable Long orderId, @RequestBody OrderItem item) {
        service.addOrderItem(orderId, item);
    }

    @DeleteMapping("/{orderId}/items")
    public void removeOrderItem(@PathVariable Long orderId, @RequestBody OrderItem item) {
        service.removeOrderItem(orderId, item);
    }

    @PostMapping("/{orderId}/process")
    public void processCustomerOrderForDelivery(@PathVariable Long orderId) {
        service.processCustomerOrderForDelivery(orderId);
    }

    @PostMapping("/{orderId}/status")
    public void updateCustomerOrderDeliveryStatus(@PathVariable Long orderId, @RequestParam String status) {
        service.updateCustomerOrderDeliveryStatus(orderId, status);
    }

    @GetMapping("/customer/{email}")
    public List<CustomerOrder> getOrdersByCustomer(@PathVariable String email) {
        return service.getOrdersByCustomer(email);
    }
}

