package com.pace.pharmapredict.controller;

import com.pace.pharmapredict.model.Supplier;
import com.pace.pharmapredict.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
@CrossOrigin(origins = "*") // Allows your HTML frontend to fetch this data
public class SupplierController {

    @Autowired
    private SupplierRepository supplierRepository;

    @GetMapping
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }
    @PostMapping
    public Supplier createSupplier(@RequestBody Supplier supplier) {
        return supplierRepository.save(supplier);
    }
}