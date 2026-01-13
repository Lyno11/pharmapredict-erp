package com.pace.pharmapredict.controller;

import com.pace.pharmapredict.dto.OrderRequest;
import com.pace.pharmapredict.model.Medication;
import com.pace.pharmapredict.repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private MedicationRepository medicationRepository;

    // NOTE: In a full production app, you would also save to a "CustomerOrder" repository here.
    // For this phase, we are focusing on the STOCK UPDATE logic.

    @PostMapping
    public ResponseEntity<String> placeOrder(@RequestBody OrderRequest request) {
        // 1. Find the Medication
        Medication med = medicationRepository.findById(request.getMedicationId()).orElse(null);

        if (med == null) {
            return ResponseEntity.badRequest().body("Error: Medication not found!");
        }

        // 2. Check Stock
        if (med.getQuantityAvailable() < request.getQuantity()) {
            return ResponseEntity.badRequest().body("Error: Insufficient stock! Only " + med.getQuantityAvailable() + " units left.");
        }

        // 3. Subtract Stock (The Business Logic)
        int newStock = med.getQuantityAvailable() - request.getQuantity();
        med.setQuantityAvailable(newStock);

        // 4. Save Changes to Database
        medicationRepository.save(med);

        return ResponseEntity.ok("Order Placed Successfully! Stock updated.");
    }
}
