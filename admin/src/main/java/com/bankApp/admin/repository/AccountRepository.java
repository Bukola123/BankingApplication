package com.bankApp.admin.repository;

import com.bankApp.admin.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {

}
