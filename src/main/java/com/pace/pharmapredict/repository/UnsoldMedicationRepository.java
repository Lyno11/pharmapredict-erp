package com.pace.pharmapredict.repository;
import com.pace.pharmapredict.model.UnsoldMedication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnsoldMedicationRepository extends JpaRepository<UnsoldMedication, Long> {}