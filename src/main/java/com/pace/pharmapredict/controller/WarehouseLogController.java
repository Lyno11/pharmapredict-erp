package com.pace.pharmapredict.controller;

import com.pace.pharmapredict.model.Medication;
import com.pace.pharmapredict.model.WarehouseLog;
import com.pace.pharmapredict.repository.MedicationRepository;
import com.pace.pharmapredict.repository.WarehouseLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/warehouse-logs")
@CrossOrigin(origins = "*")
public class WarehouseLogController {

    @Autowired
    private WarehouseLogRepository warehouseLogRepository;

    @Autowired
    private MedicationRepository medicationRepository; // Needed to update inventory

    @GetMapping
    public List<WarehouseLog> getAllLogs() {
        return warehouseLogRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<String> receiveStock(@RequestBody WarehouseLog log) {
        //Validate Medication Exists
        Optional<Medication> medOpt = medicationRepository.findById(log.getMedicationId());

        if (medOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Error: Medication ID not found.");
        }

        Medication med = medOpt.get();

        // BUSINESS LOGIC: Add received quantity to current stock
        // (Inventory goes UP when we receive shipment)
        if (log.getQuantityReceived() != null && log.getQuantityReceived() > 0) {
            int newStock = med.getQuantityAvailable() + log.getQuantityReceived();
            med.setQuantityAvailable(newStock);
            medicationRepository.save(med); // Save the new stock level
        }

        //Set timestamp if missing
        if (log.getLogDate() == null) {
            log.setLogDate(LocalDateTime.now());
        }

        warehouseLogRepository.save(log);

        return ResponseEntity.ok("Stock Received! Inventory updated to: " + med.getQuantityAvailable());
    }
}