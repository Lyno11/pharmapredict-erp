package com.pace.pharmapredict.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "Unsold_Medications_List")
public class UnsoldMedication {
    @Id
    @Column(name = "ndc_code")
    private Long ndcCode;

    private String name;

    public Long getNdcCode() { return ndcCode; }
    public String getName() { return name; }
}