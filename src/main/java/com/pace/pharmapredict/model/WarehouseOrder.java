package com.pace.pharmapredict.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Warehouse_Order")
public class WarehouseOrder {

    @Id
    @Column(name = "warehouse_order_id")
    private String warehouseOrderId;

    @Column(name = "medication_id")
    private Long medicationId;

    @Column(name = "supplier_id")
    private String supplierId;

    @Column(name = "stock_on_order")
    private Integer stockOnOrder;

    @Column(name = "delivery_date")
    private LocalDate deliveryDate;

    // --- Getters and Setters ---
    public String getWarehouseOrderId() { return warehouseOrderId; }
    public void setWarehouseOrderId(String warehouseOrderId) { this.warehouseOrderId = warehouseOrderId; }

    public Long getMedicationId() { return medicationId; }
    public void setMedicationId(Long medicationId) { this.medicationId = medicationId; }

    public String getSupplierId() { return supplierId; }
    public void setSupplierId(String supplierId) { this.supplierId = supplierId; }

    public Integer getStockOnOrder() { return stockOnOrder; }
    public void setStockOnOrder(Integer stockOnOrder) { this.stockOnOrder = stockOnOrder; }

    public LocalDate getDeliveryDate() { return deliveryDate; }
    public void setDeliveryDate(LocalDate deliveryDate) { this.deliveryDate = deliveryDate; }
}
