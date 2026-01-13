package com.pace.pharmapredict.controller;

import com.pace.pharmapredict.model.Medication;
import com.pace.pharmapredict.repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/medications")
@CrossOrigin(origins = "*") // Crucial: Allows your future JS frontend to talk to this Java backend
public class MedicationController {

    @Autowired
    private MedicationRepository medicationRepository;

    // GET http://localhost:8080/api/medications
    @GetMapping
    public List<Medication> getAllMedications() {
        return medicationRepository.findAll();
    }

    // POST http://localhost:8080/api/medications
    @PostMapping
    public Medication createMedication(@RequestBody Medication medication) {
        try {
            return medicationRepository.save(medication);
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Saving Medication Failed!!!");
        }
    }
}