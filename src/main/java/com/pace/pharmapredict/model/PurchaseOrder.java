package com.pace.pharmapredict.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Purchase_Order") // Matches SQL table exactly
public class PurchaseOrder {

    @Id
    @Column(name = "order_id")
    private String orderId;

    @Column(name = "supplier_id")
    private String supplierId;

    @Column(name = "order_date")
    private LocalDate orderDate;

    private String status;

    @Column(name = "total_cost")
    private BigDecimal totalCost;

    // --- Getters and Setters ---

    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }

    public String getSupplierId() { return supplierId; }
    public void setSupplierId(String supplierId) { this.supplierId = supplierId; }

    public LocalDate getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDate orderDate) { this.orderDate = orderDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public BigDecimal getTotalCost() { return totalCost; }
    public void setTotalCost(BigDecimal totalCost) { this.totalCost = totalCost; }
}