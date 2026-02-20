package com.pace.pharmapredict.controller;

import com.pace.pharmapredict.model.*;
import com.pace.pharmapredict.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "*")
public class DashboardController {

    @Autowired private LowStockAlertRepository lowStockRepo;
    @Autowired private PendingShipmentRepository pendingShipmentRepo;
    @Autowired private CustomerLifetimeValueRepository clvRepo;
    @Autowired private WarehouseValuationRepository valuationRepo;
    @Autowired private ExpiryWatchlistRepository expiryRepo;
    @Autowired private TopSellingProductRepository topSellingRepo;
    @Autowired private MedicationManufacturerRepository medManufacRepo;
    @Autowired private UnsoldMedicationRepository unsoldRepo;


    @GetMapping("/low-stock")
    public List<LowStockAlert> getLowStockAlerts() { return lowStockRepo.findAll(); }

    @GetMapping("/pending-shipments")
    public List<PendingShipment> getPendingShipments() { return pendingShipmentRepo.findAll(); }

    @GetMapping("/clv")
    public List<CustomerLifetimeValue> getCustomerLifetimeValue() { return clvRepo.findAll(); }

    @GetMapping("/valuation")
    public List<WarehouseValuation> getWarehouseValuation() { return valuationRepo.findAll(); }

    @GetMapping("/expiring")
    public List<ExpiryWatchlist> getExpiryWatchlist() { return expiryRepo.findAll(); }

    @GetMapping("/top-selling")
    public List<TopSellingProduct> getTopSelling() { return topSellingRepo.findAll(); }

    @GetMapping("/med-manufacturers")
    public List<MedicationManufacturer> getMedManufacturers() { return medManufacRepo.findAll(); }

    @GetMapping("/unsold")
    public List<UnsoldMedication> getUnsoldMeds() { return unsoldRepo.findAll(); }
}
