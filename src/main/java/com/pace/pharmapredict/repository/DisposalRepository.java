package com.pace.pharmapredict.repository;

import com.pace.pharmapredict.model.Disposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisposalRepository extends JpaRepository<Disposal, String> {
}