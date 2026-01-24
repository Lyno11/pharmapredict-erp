package com.pace.pharmapredict.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Customer_Order")
public class CustomerOrder {

    @Id
    @Column(name = "order_id")
    private String orderId;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "total_cost")
    private BigDecimal totalCost;

    private String status;

    // --- Getters and Setters ---
    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public LocalDate getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDate orderDate) { this.orderDate = orderDate; }

    public BigDecimal getTotalCost() { return totalCost; }
    public void setTotalCost(BigDecimal totalCost) { this.totalCost = totalCost; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}