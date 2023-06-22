package com.bankApp.authentication.auth.repository;

import com.bankApp.authentication.auth.model.Account;
import com.bankApp.authentication.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

    @Query("SELECT u FROM User u WHERE u.userId = ?1")
    User findByUserID(Long userID);

//
//    @Query("SELECT u FROM User u WHERE u.userId = ?1")
//    User updateUserById(String id);
//
//    private String accountNo;
//    private String email;
//    private String phone;
//    private String address;
//update User set (email,phone,address) value () where userId = ?1



}
