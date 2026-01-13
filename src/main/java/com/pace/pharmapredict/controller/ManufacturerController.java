package com.pace.pharmapredict.controller;

import com.pace.pharmapredict.model.Customer;
import com.pace.pharmapredict.model.Manufacturer;
import com.pace.pharmapredict.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/manufacturers")
@CrossOrigin(origins = "*")
public class ManufacturerController {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @GetMapping
    public List<Manufacturer> getAllManufacturers() {
        return manufacturerRepository.findAll();
    }
    @PostMapping
    public Manufacturer createManufacturer(@RequestBody Manufacturer manufacturer) {
        return manufacturerRepository.save(manufacturer);
    }
}
