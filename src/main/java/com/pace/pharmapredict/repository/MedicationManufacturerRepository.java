package com.pace.pharmapredict.repository;
import com.pace.pharmapredict.model.MedicationManufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationManufacturerRepository extends JpaRepository<MedicationManufacturer, Long> {}