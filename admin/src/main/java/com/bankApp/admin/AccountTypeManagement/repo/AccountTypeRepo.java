package com.bankApp.admin.AccountTypeManagement.repo;

import com.bankApp.admin.AccountTypeManagement.model.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTypeRepo extends JpaRepository<AccountType,Long> {
//    @Query("SELECT a from AccountType")
//    AccountType getAllAccountType(AccountType accountType);
}
