package com.bankApp.transaction.repo;

import com.bankApp.transaction.model.Transactions;
import org.springframework.data.jpa.mapping.JpaPersistentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepoInterface extends JpaRepository<Transactions, Integer> {


}
