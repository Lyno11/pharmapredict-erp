package com.pace.pharmapredict.repository;

import com.pace.pharmapredict.model.LowStockAlert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LowStockAlertRepository extends JpaRepository<LowStockAlert, String> {
}
