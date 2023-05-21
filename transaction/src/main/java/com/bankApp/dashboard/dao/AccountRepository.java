package com.bankApp.dashboard.dao;

import com.bankApp.dashboard.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<Account,Integer> {

    @Query("SELECT a FROM Account a WHERE a.accountNo = ?1")
    Account getBalanceByAcct(String accountNo);
}
