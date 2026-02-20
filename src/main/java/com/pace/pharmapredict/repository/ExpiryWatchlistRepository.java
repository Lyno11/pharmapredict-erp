package com.pace.pharmapredict.repository;
import com.pace.pharmapredict.model.ExpiryWatchlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpiryWatchlistRepository extends JpaRepository<ExpiryWatchlist, String> {}