package com.pace.pharmapredict.repository;

import com.pace.pharmapredict.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long> {
    // Spring Data JPA automatically generates the implementation!
}