package com.bankApp.authentication.repository;

import com.bankApp.authentication.model.MobileBankingDetails;
import com.bankApp.authentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MobileBankingRepository extends JpaRepository<MobileBankingDetails, Integer> {
    @Query("SELECT m FROM MobileBankingDetails m WHERE m.username = ?1")
    MobileBankingDetails findByUsername(String username);
}
