package com.pace.pharmapredict.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Medication")
public class Medication {

    @Id
    @Column(name = "ndcCode")
    private Long ndcCode; // Matches BIGINT in MySQL

    private String name;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    private String type;
    //Updates from
    //@Column(name = "manufacturerID")
    //private String manufacturerID;
    @Column(name = "manufacturer_id") // Matches the new DB column perfectly
    private String manufacturerID;

    private String format;
    private BigDecimal price; // Matches DECIMAL(10,2)

    @Column(name = "quantity_available")
    private Integer quantityAvailable;

    private String description;

    // --- GETTERS AND SETTERS ---
    // (You can generate these in IntelliJ by pressing Alt+Insert -> Getter and Setter -> Select All)

    public Long getNdcCode() { return ndcCode; }
    public void setNdcCode(Long ndcCode) { this.ndcCode = ndcCode; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDate getExpirationDate() { return expirationDate; }
    public void setExpirationDate(LocalDate expirationDate) { this.expirationDate = expirationDate; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getManufacturerID() { return manufacturerID; }
    public void setManufacturerID(String manufacturerID) { this.manufacturerID = manufacturerID; }

    public String getFormat() { return format; }
    public void setFormat(String format) { this.format = format; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public Integer getQuantityAvailable() { return quantityAvailable; }
    public void setQuantityAvailable(Integer quantityAvailable) { this.quantityAvailable = quantityAvailable; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}