package com.pace.pharmapredict.repository;
import com.pace.pharmapredict.model.TopSellingProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopSellingProductRepository extends JpaRepository<TopSellingProduct, String> {}