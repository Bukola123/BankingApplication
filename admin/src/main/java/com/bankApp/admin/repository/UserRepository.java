package com.bankApp.admin.repository;

import com.bankApp.admin.model.User;
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
//    @Query("SELECT accountId FROM Account a WHERE a.accountNo = ?1")
    User findByAccount(String accountNo);



}
