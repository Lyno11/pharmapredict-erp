package com.pace.pharmapredict.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "Low_Stock_Alert")
public class LowStockAlert {

    @Id
    private String name;

    @Column(name = "current_stock")
    private Integer currentStock;

    @Column(name = "reorder_level")
    private Integer reorderLevel;

    // --- Getters ---
    public String getName() { return name; }
    public Integer getCurrentStock() { return currentStock; }
    public Integer getReorderLevel() { return reorderLevel; }
}