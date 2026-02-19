package com.pace.pharmapredict.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;
import java.time.LocalDate;

@Entity
@Immutable
@Table(name = "Expiry_Watchlist")
public class ExpiryWatchlist {
    @Id
    private String name;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @Column(name = "quantity_available")
    private Integer quantityAvailable;

    public String getName() { return name; }
    public LocalDate getExpirationDate() { return expirationDate; }
    public Integer getQuantityAvailable() { return quantityAvailable; }
}