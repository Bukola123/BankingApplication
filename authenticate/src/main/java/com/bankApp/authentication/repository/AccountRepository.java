package com.bankApp.authentication.repository;

import com.bankApp.authentication.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {

}
