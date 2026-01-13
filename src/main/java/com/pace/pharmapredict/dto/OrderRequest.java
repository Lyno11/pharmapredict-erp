package com.pace.pharmapredict.dto;

public class OrderRequest {
    private String customerId;
    private Long medicationId; // Matches ndc_code
    private Integer quantity;

    // Getters and Setters
    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }
    public Long getMedicationId() { return medicationId; }
    public void setMedicationId(Long medicationId) { this.medicationId = medicationId; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}
