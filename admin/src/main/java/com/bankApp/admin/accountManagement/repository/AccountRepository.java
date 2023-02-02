package com.bankApp.admin.accountManagement.repository;

import com.bankApp.admin.accountManagement.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {

}
