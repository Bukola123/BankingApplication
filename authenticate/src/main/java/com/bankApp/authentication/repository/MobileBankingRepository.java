package com.bankApp.authentication.repository;

import com.bankApp.authentication.model.MobileBankingDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MobileBankingRepository extends JpaRepository<MobileBankingDetails, Integer> {
}
