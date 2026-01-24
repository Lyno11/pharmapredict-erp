package com.pace.pharmapredict.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Customer_Order_Detail")
public class CustomerOrderDetail {

    @Id
    @Column(name = "detail_id")
    private String detailId;

    @Column(name = "order_id")
    private String orderId;

    @Column(name = "medication_id")
    private Long medicationId;

    @Column(name = "quantity_ordered")
    private Integer quantityOrdered;

    @Column(name = "price_at_sale")
    private BigDecimal priceAtSale;

    // --- Getters and Setters ---
    public String getDetailId() { return detailId; }
    public void setDetailId(String detailId) { this.detailId = detailId; }

    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }

    public Long getMedicationId() { return medicationId; }
    public void setMedicationId(Long medicationId) { this.medicationId = medicationId; }

    public Integer getQuantityOrdered() { return quantityOrdered; }
    public void setQuantityOrdered(Integer quantityOrdered) { this.quantityOrdered = quantityOrdered; }

    public BigDecimal getPriceAtSale() { return priceAtSale; }
    public void setPriceAtSale(BigDecimal priceAtSale) { this.priceAtSale = priceAtSale; }
}