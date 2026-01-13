package com.pace.pharmapredict.controller;

import com.pace.pharmapredict.model.Disposal;
import com.pace.pharmapredict.model.Medication;
import com.pace.pharmapredict.repository.DisposalRepository;
import com.pace.pharmapredict.repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/disposals")
@CrossOrigin(origins = "*")
public class DisposalController {

    @Autowired
    private DisposalRepository disposalRepository;

    @Autowired
    private MedicationRepository medicationRepository; // <--- 1. We need access to Inventory

    @GetMapping
    public List<Disposal> getAllDisposals() {
        return disposalRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<String> recordDisposal(@RequestBody Disposal disposal) {

        // --- START BUSINESS LOGIC ---

        // 2. Find the Medication first
        Optional<Medication> medOpt = medicationRepository.findById(disposal.getMedicationId());

        if (medOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Error: Medication ID " + disposal.getMedicationId() + " not found.");
        }

        Medication med = medOpt.get();

        // 3. Validation: Do we actually have this much to throw away?
        if (med.getQuantityAvailable() < disposal.getQuantity()) {
            return ResponseEntity.badRequest().body("Error: Cannot dispose " + disposal.getQuantity() +
                    ". Only " + med.getQuantityAvailable() + " in stock.");
        }

        // 4. THE SUBTRACTION LOGIC
        int newStock = med.getQuantityAvailable() - disposal.getQuantity();
        med.setQuantityAvailable(newStock);

        // 5. Save BOTH changes (Update Stock + Record Log)
        medicationRepository.save(med);     // Updates the Inventory
        disposalRepository.save(disposal);  // Saves the Disposal Record

        // --- END BUSINESS LOGIC ---

        return ResponseEntity.ok("Disposal Recorded. Stock updated.");
    }
}