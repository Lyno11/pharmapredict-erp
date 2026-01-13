package com.pace.pharmapredict.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Disposals") // Matches your SQL table name exactly
public class Disposal {

    @Id
    @Column(name = "disposal_id")
    private String disposalId;

    @Column(name = "medication_id")
    private Long medicationId; // Matches the BIGINT ndc_code from Medication table

    private Integer quantity;
    private String reason;

    @Column(name = "disposal_date")
    private LocalDate disposalDate;

    // --- Getters and Setters ---

    public String getDisposalId() { return disposalId; }
    public void setDisposalId(String disposalId) { this.disposalId = disposalId; }

    public Long getMedicationId() { return medicationId; }
    public void setMedicationId(Long medicationId) { this.medicationId = medicationId; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public LocalDate getDisposalDate() { return disposalDate; }
    public void setDisposalDate(LocalDate disposalDate) { this.disposalDate = disposalDate; }
}