package com.bankApp.authentication.repository;

import com.bankApp.authentication.model.Account;
import com.bankApp.authentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User findByEmail(String email);

//    @Query("SELECT * FROM User u, Account a WHERE u.account_id = a.account_id")
//    @Query("SELECT u FROM User u WHERE u.accountId = (SELECT accountId FROM Account a WHERE a.accountNo = ?1)")
//    @Query("SELECT u FROM User u WHERE u.accountId_fk = ?1")
//    @Query("SELECT u FROM User u INNER JOIN  User ON u.accountId = Account.accountId")
//    @Query("SELECT a FROM Account a WHERE a.accountNo = ?1")
    @Query("SELECT a FROM Account a WHERE a.accountNo = ?1")
    Account findByAccountNo(String accountNo);
    User findByAccount_Id(Long accountId);



}
