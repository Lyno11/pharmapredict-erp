package com.pace.pharmapredict.dto;

import java.util.List;

public class CartRequest {
    private String customerId;
    private List<CartItem> items;

    // Inner class for the items
    public static class CartItem {
        public Long medicationId;
        public Integer quantity;
    }

    // Getters and Setters
    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }
    public List<CartItem> getItems() { return items; }
    public void setItems(List<CartItem> items) { this.items = items; }
}