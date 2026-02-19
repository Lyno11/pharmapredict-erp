package com.pace.pharmapredict.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;
import java.time.LocalDate;

@Entity
@Immutable
@Table(name = "Pending_Shipments")
public class PendingShipment {

    @Id
    @Column(name = "order_id")
    private String orderId;

    private String status;

    @Column(name = "estimated_delivery")
    private LocalDate estimatedDelivery;

    @Column(name = "Supplier_Name")
    private String supplierName;

    // --- Getters ---
    public String getOrderId() { return orderId; }
    public String getStatus() { return status; }
    public LocalDate getEstimatedDelivery() { return estimatedDelivery; }
    public String getSupplierName() { return supplierName; }
}
