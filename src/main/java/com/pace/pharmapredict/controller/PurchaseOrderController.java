package com.pace.pharmapredict.controller;

import com.pace.pharmapredict.model.PurchaseOrder;
import com.pace.pharmapredict.repository.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchase-orders") // Matches your frontend fetch call
@CrossOrigin(origins = "*")
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    @GetMapping
    public List<PurchaseOrder> getAllOrders() {
        return purchaseOrderRepository.findAll();
    }
}