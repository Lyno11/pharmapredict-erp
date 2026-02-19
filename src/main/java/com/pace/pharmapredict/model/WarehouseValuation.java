package com.pace.pharmapredict.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;
import java.math.BigDecimal;

@Entity
@Immutable
@Table(name = "Warehouse_Valuation")
public class WarehouseValuation {
    @Id
    private String name;

    @Column(name = "current_stock")
    private Integer currentStock;

    private BigDecimal price;

    @Column(name = "Total_Value")
    private BigDecimal totalValue;

    public String getName() { return name; }
    public Integer getCurrentStock() { return currentStock; }
    public BigDecimal getPrice() { return price; }
    public BigDecimal getTotalValue() { return totalValue; }
}