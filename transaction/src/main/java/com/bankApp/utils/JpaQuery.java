package com.bankApp.utils;

import com.bankApp.dashboard.model.Account;
import com.bankApp.transaction.model.PostingRequest;
import com.bankApp.transaction.model.Transactions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;

@Repository
@Transactional
@Slf4j
public class JpaQuery {

@PersistenceContext
private EntityManager entityManager;

public Transactions updateTransaction(Transactions request) {
String jpql = "UPDATE Transactions e SET e.fromAccount = :fromAccount, e.toAccount = :toAccount, e.amount = :amount, e.narration = :narration, e.status = :status, e.externalId = :externalId, e.updateDate = :updateDate where e.transId =: transId";

entityManager.createQuery(jpql)

        .setParameter("fromAccount", request.getFromAccount())
        .setParameter("toAccount", request.getToAccount())
        .setParameter("amount", request.getAmount())
        .setParameter("updateDate", request.getUpdateDate())
        .setParameter("narration", request.getNarration())
        .setParameter("externalId", request.getExternalId())
        .setParameter("status", request.getStatus())
        .setParameter("transId", request.getTransId())
        .executeUpdate();


return entityManager.find(Transactions.class, request.getTransId());
}


    public Transactions updateAfterPosting(Transactions request) {
        String jpql = "UPDATE Transactions e SET  e.status = :status, e.updateDate = :updateDate where e.transId =: transId";

        entityManager.createQuery(jpql)

                .setParameter("status", request.getStatus())
                .setParameter("transId", request.getTransId())
                .setParameter("updateDate", request.getUpdateDate())

                .executeUpdate();


        return entityManager.find(Transactions.class, request.getTransId());
    }


    public Account postingTransaction(PostingRequest request) {
        log.info("Posting query {}", request);
        String jpql = "UPDATE Account e SET e.availableBal = :availableBal, e.withrawableBal = :withrawableBal, e.updateDate = :updateDate WHERE e.accountNo = :accountNo";

        entityManager.createQuery(jpql)
                .setParameter("availableBal", request.getAvailableBal())
                .setParameter("withrawableBal", request.getWithrawableBal())
                .setParameter("updateDate", request.getUpdateDate())
                .setParameter("accountNo", request.getAccountNo())
                .executeUpdate();

        return entityManager.createQuery("SELECT e FROM Account e WHERE e.accountNo = :accountNo", Account.class)
                .setParameter("accountNo", request.getAccountNo())
                .getSingleResult();
    }


//    public Account postingTransaction(PostingRequest request) {
//    log.info("Positng query {}", request);
//        String jpql = "UPDATE Account e SET e.availableBal = :availableBal, e.withrawableBal = :withrawableBal, e.updateDate = :updateDate where e.accountNo =: accountNo";
//
//
//
//
//        entityManager.createQuery(jpql)
//
//                .setParameter("availableBal", request.getAvailableBal())
//                .setParameter("withrawableBal", request.getWithrawableBal())
//                .setParameter("updateDate", request.getUpdateDate())
//                .setParameter("accountNo", request.getAccountNo())
//                .executeUpdate();
//
//
//        return entityManager.find(Account.class, request.getAccountNo());
//    }
}
