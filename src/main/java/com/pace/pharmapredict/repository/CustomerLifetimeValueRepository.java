package com.pace.pharmapredict.repository;
import com.pace.pharmapredict.model.CustomerLifetimeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerLifetimeValueRepository extends JpaRepository<CustomerLifetimeValue, String> {}