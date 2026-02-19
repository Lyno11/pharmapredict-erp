package com.pace.pharmapredict.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;
import java.math.BigDecimal;

@Entity
@Immutable
@Table(name = "Customer_Lifetime_Value")
public class CustomerLifetimeValue {
    @Id
    private String name;

    @Column(name = "Total_Orders")
    private Long totalOrders;

    @Column(name = "Total_Spent")
    private BigDecimal totalSpent;

    public String getName() { return name; }
    public Long getTotalOrders() { return totalOrders; }
    public BigDecimal getTotalSpent() { return totalSpent; }
}