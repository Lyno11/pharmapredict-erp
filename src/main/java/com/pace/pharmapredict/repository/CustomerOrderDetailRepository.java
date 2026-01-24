package com.pace.pharmapredict.repository;

import com.pace.pharmapredict.model.CustomerOrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerOrderDetailRepository extends JpaRepository<CustomerOrderDetail, String> {
    // Helper to find items for a specific order
    List<CustomerOrderDetail> findByOrderId(String orderId);
}