package com.pace.pharmapredict.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Manufacturer")

public class Manufacturer {
    @Id
    @Column(name = "manufacturer_id")
    private String manufacturerId;

    private String name;
    private String phone;
    private String email;
    private String address;

    // Getters and Setters
    public String getManufacturerId() { return manufacturerId; }
    public void setManufacturerId(String manufacturerId) { this.manufacturerId = manufacturerId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
