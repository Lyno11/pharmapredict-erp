package com.pace.pharmapredict.controller;

import com.pace.pharmapredict.dto.CartRequest;
import com.pace.pharmapredict.model.CustomerOrder;
import com.pace.pharmapredict.model.CustomerOrderDetail;
import com.pace.pharmapredict.model.Medication;
import com.pace.pharmapredict.repository.CustomerOrderDetailRepository;
import com.pace.pharmapredict.repository.CustomerOrderRepository;
import com.pace.pharmapredict.repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/sales")
@CrossOrigin(origins = "*")
public class CustomerOrderController {

    @Autowired
    private CustomerOrderRepository orderRepo;
    @Autowired
    private CustomerOrderDetailRepository detailRepo;
    @Autowired
    private MedicationRepository medRepo;

    @GetMapping("/history")
    public List<CustomerOrder> getAllOrders() {
        return orderRepo.findAll();
    }

    @PostMapping("/checkout")
    @Transactional
    public ResponseEntity<String> checkout(@RequestBody CartRequest request) {

        // 1. Create & SAVE the Order Header FIRST (Empty for now)
        CustomerOrder order = new CustomerOrder();
        String orderId = "ORD-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        order.setOrderId(orderId);
        order.setCustomerId(request.getCustomerId());
        order.setOrderDate(LocalDate.now());
        order.setStatus("PROCESSING");
        order.setTotalCost(BigDecimal.ZERO); // Temporary 0

        // *** CRITICAL FIX: Save Parent before Children ***
        orderRepo.save(order);

        BigDecimal grandTotal = BigDecimal.ZERO;

        // 2. Loop through items
        for (CartRequest.CartItem item : request.getItems()) {
            Medication med = medRepo.findById(item.medicationId).orElse(null);

            if (med == null) {
                throw new RuntimeException("Medication ID " + item.medicationId + " not found.");
            }
            if (med.getQuantityAvailable() < item.quantity) {
                throw new RuntimeException("Insufficient stock for: " + med.getName());
            }

            // Logic: Subtract Stock
            med.setQuantityAvailable(med.getQuantityAvailable() - item.quantity);
            medRepo.save(med);

            // Logic: Calculate Cost
            BigDecimal quantityBD = BigDecimal.valueOf(item.quantity);
            BigDecimal lineCost = med.getPrice().multiply(quantityBD);
            grandTotal = grandTotal.add(lineCost);

            // Logic: Save Detail Record
            CustomerOrderDetail detail = new CustomerOrderDetail();
            detail.setDetailId("DET-" + UUID.randomUUID().toString().substring(0, 8));
            detail.setOrderId(orderId); // This works now because 'orderId' exists in DB!
            detail.setMedicationId(item.medicationId);
            detail.setQuantityOrdered(item.quantity);
            detail.setPriceAtSale(med.getPrice());

            detailRepo.save(detail);
        }

        // 3. Update the Order with the Final Total
        order.setTotalCost(grandTotal);
        order.setStatus("COMPLETED");
        orderRepo.save(order); // Update the parent record

        return ResponseEntity.ok("Order Placed Successfully! ID: " + orderId);
    }
}