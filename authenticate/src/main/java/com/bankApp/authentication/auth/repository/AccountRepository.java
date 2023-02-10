package com.bankApp.authentication.auth.repository;

import com.bankApp.authentication.auth.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {

}
