package com.pace.pharmapredict.repository;

import com.pace.pharmapredict.model.WarehouseLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseLogRepository extends JpaRepository<WarehouseLog, String> {
}