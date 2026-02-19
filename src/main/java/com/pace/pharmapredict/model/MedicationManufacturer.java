package com.pace.pharmapredict.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "Medication_Manufacturer_List")
public class MedicationManufacturer {
    @Id
    @Column(name = "ndc_code")
    private Long ndcCode;

    @Column(name = "Medication_Name")
    private String medicationName;

    private String type;

    @Column(name = "Manufacturer_Name")
    private String manufacturerName;

    private String phone;
    private String email;
    private String address;

    public Long getNdcCode() { return ndcCode; }
    public String getMedicationName() { return medicationName; }
    public String getType() { return type; }
    public String getManufacturerName() { return manufacturerName; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public String getAddress() { return address; }
}