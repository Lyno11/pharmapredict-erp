package com.pace.pharmapredict.repository;

import com.pace.pharmapredict.model.PendingShipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PendingShipmentRepository extends JpaRepository<PendingShipment, String> {
}