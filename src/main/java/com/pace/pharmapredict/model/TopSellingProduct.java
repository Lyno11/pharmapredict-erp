package com.pace.pharmapredict.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "Top_Selling_Products")
public class TopSellingProduct {
    @Id
    private String name;

    @Column(name = "Total_Sold")
    private Long totalSold;

    public String getName() { return name; }
    public Long getTotalSold() { return totalSold; }
}