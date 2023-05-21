package com.bankApp.authentication.auth.repository;

import com.bankApp.authentication.auth.model.MobileBankingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MobileBankingRepository extends JpaRepository<MobileBankingDetails, Integer> {
    @Query("SELECT m FROM MobileBankingDetails m WHERE m.username = ?1")
    MobileBankingDetails findByUsername(String username);
}
