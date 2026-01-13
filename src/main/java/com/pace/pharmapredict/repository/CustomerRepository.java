package com.pace.pharmapredict.repository;

import com.pace.pharmapredict.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
}
