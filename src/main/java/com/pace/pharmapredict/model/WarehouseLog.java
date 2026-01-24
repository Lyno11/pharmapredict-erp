package com.pace.pharmapredict.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Warehouse_Log")
public class WarehouseLog {

    @Id
    @Column(name = "log_id")
    private String logId;

    @Column(name = "warehouse_order_id")
    private String warehouseOrderId;

    @Column(name = "medication_id")
    private Long medicationId;

    @Column(name = "quantity_received")
    private Integer quantityReceived;

    private String status;

    @Column(name = "date_closed")
    private LocalDate dateClosed;

    private String notes;
    private String author;

    @Column(name = "log_date")
    private LocalDateTime logDate;

    // --- Getters and Setters ---
    public String getLogId() { return logId; }
    public void setLogId(String logId) { this.logId = logId; }

    public String getWarehouseOrderId() { return warehouseOrderId; }
    public void setWarehouseOrderId(String warehouseOrderId) { this.warehouseOrderId = warehouseOrderId; }

    public Long getMedicationId() { return medicationId; }
    public void setMedicationId(Long medicationId) { this.medicationId = medicationId; }

    public Integer getQuantityReceived() { return quantityReceived; }
    public void setQuantityReceived(Integer quantityReceived) { this.quantityReceived = quantityReceived; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDate getDateClosed() { return dateClosed; }
    public void setDateClosed(LocalDate dateClosed) { this.dateClosed = dateClosed; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public LocalDateTime getLogDate() { return logDate; }
    public void setLogDate(LocalDateTime logDate) { this.logDate = logDate; }
}