package com.pace.pharmapredict.repository;
import com.pace.pharmapredict.model.WarehouseValuation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseValuationRepository extends JpaRepository<WarehouseValuation, String> {}