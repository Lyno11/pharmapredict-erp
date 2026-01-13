package com.pace.pharmapredict.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @Column(name = "customer_id")
    private String customerId;

    private String name;
    private String phone;
    private String email;
    private String address;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    // Getters and Setters
    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }
}
