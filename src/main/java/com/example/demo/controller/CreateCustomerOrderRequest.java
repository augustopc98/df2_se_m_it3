package com.example.demo.controller;

import com.example.demo.domain.OrderItem;
import java.util.List;

public class CreateCustomerOrderRequest {

    private String customerEmail;
    private String customerAddress;
    private List<OrderItem> items;

    // Constructor vacío
    public CreateCustomerOrderRequest() {}

    // Getters y Setters
    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}
