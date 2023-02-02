package com.bankApp.authentication.repository;

import com.bankApp.authentication.model.BalanceTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceRepo extends JpaRepository<String, BalanceTable> {
}
