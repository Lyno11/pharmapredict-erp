package com.pace.pharmapredict.controller;

import com.pace.pharmapredict.model.WarehouseOrder;
import com.pace.pharmapredict.repository.WarehouseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/warehouse-orders")
@CrossOrigin(origins = "*")
public class WarehouseOrderController {

    @Autowired
    private WarehouseOrderRepository warehouseOrderRepository;

    @GetMapping
    public List<WarehouseOrder> getAllOrders() {
        return warehouseOrderRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<WarehouseOrder> createOrder(@RequestBody WarehouseOrder order) {
        // Business Logic: Default Delivery Date = Today + 5 Days (SYSDATE+5)
        if (order.getDeliveryDate() == null) {
            order.setDeliveryDate(LocalDate.now().plusDays(5));
        }

        WarehouseOrder savedOrder = warehouseOrderRepository.save(order);
        return ResponseEntity.ok(savedOrder);
    }
}