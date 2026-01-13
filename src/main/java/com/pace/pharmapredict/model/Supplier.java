package com.pace.pharmapredict.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Supplier")

public class Supplier {
    @Id
    @Column (name = "supplier_id")
    private String supplierId;

    private String name;
    private String phone;
    private String email;
    private String address;

    // Getters and Setters
    public String getSupplierId() { return supplierId; }
    public void setSupplierId(String supplierId) { this.supplierId = supplierId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
