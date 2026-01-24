package com.pace.pharmapredict.repository;

import com.pace.pharmapredict.model.WarehouseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseOrderRepository extends JpaRepository<WarehouseOrder, String> {
}