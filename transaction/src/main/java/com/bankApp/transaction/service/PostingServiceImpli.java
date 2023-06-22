package com.bankApp.transaction.service;

import com.bankApp.dashboard.dao.AccountRepository;
import com.bankApp.dashboard.model.Account;
import com.bankApp.transaction.model.PostingRequest;
import com.bankApp.transaction.model.Transactions;
import com.bankApp.utils.JpaQuery;
import com.bankApp.utils.Response;
import com.bankApp.utils.exemptions.GeneralExceptions;
import com.bankApp.utils.general.enums.ResponseCodes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostingServiceImpli implements PostingServiceInterface{

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    JpaQuery jpaQuery;

    public Response postingService(Transactions transactions){
        Response response = new Response();

        log.info("Transaction {}", transactions);

        if(transactions.getTypeOfTransaction().equalsIgnoreCase("INTERNAL-TRANSFER")){
            response = InternalTransfer(transactions);

        } else if( transactions.getTypeOfTransaction().equalsIgnoreCase("INTER-TRANSFER")) {

        } else if( transactions.getTypeOfTransaction().equalsIgnoreCase("WITHDRAWL")) {
            response =  withdraw(transactions);

        } else if( transactions.getTypeOfTransaction().equalsIgnoreCase("DEPOSIT")) {
            response = deposit(transactions);
        } else {

        }


        return response;
    }


    public Response deposit(Transactions transactions){

        log.info("Performing Deposit");
        Response response = new Response();

        Account toAccount =  new Account();
        Account fromAccount =  new Account();

        PostingRequest postingRequest = new PostingRequest();

        try{

            //Get deposit GL

            transactions.setFromAccount("0062823176");
            //Get balance
            fromAccount = accountRepository.findByAccountNo(transactions.getFromAccount());

            //from account
            postingRequest.setAccountNo(transactions.getFromAccount());
            postingRequest.setWithrawableBal(fromAccount.getWithrawableBal()-transactions.getAmount());
            postingRequest.setAvailableBal(fromAccount.getAvailableBal()-transactions.getAmount());
            postingRequest.setUpdateDate(LocalDateTime.now());

            fromAccount = jpaQuery.postingTransaction(postingRequest);

            //to account
            if(fromAccount != null) {
                toAccount = accountRepository.findByAccountNo(transactions.getToAccount());
                postingRequest.setAccountNo(transactions.getToAccount());
                postingRequest.setWithrawableBal(transactions.getAmount() + toAccount.getWithrawableBal());
                postingRequest.setAvailableBal(transactions.getAmount() + toAccount.getAvailableBal());
                postingRequest.setUpdateDate(LocalDateTime.now());


                toAccount = jpaQuery.postingTransaction(postingRequest);

                if (toAccount.getAccountNo() != null) {
                    response.setResponseCode(ResponseCodes.Success.getCode());
                    response.setResponseMessage(ResponseCodes.Success.getMessage());
                } else {
                    response.setResponseCode(ResponseCodes.Failed.getCode());
                    response.setResponseMessage(ResponseCodes.Failed.getMessage());
                }
            }else{
                response.setResponseCode(ResponseCodes.Failed.getCode());
                response.setResponseMessage(ResponseCodes.Failed.getMessage());
            }
        }catch(Exception ex){
            log.info("Deposit error: {}", ex);
            throw new GeneralExceptions(ResponseCodes.INTERNAL_SERVER_ERROR,ResponseCodes.INTERNAL_SERVER_ERROR.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
        }


        log.info("Posting response {}", response);
        return response;
    }




    public Response withdraw(Transactions transactions){

        log.info("Performing withdraw");
        Response response = new Response();

        Account toAccount =  new Account();
        Account fromAccount =  new Account();

        PostingRequest postingRequest = new PostingRequest();

        try{

            //Get balance
            fromAccount = accountRepository.findByAccountNo(transactions.getFromAccount());

            //from account
            postingRequest.setAccountNo(transactions.getFromAccount());
            postingRequest.setWithrawableBal(fromAccount.getWithrawableBal()-transactions.getAmount());
            postingRequest.setAvailableBal( fromAccount.getAvailableBal()-transactions.getAmount());
            postingRequest.setUpdateDate(LocalDateTime.now());

            fromAccount = jpaQuery.postingTransaction(postingRequest);

            //to account

            //Get deposit GL

            transactions.setToAccount("0062823176");
            if(fromAccount != null) {
                toAccount = accountRepository.findByAccountNo(transactions.getToAccount());
                postingRequest.setAccountNo(transactions.getToAccount());
                postingRequest.setWithrawableBal(transactions.getAmount() + toAccount.getWithrawableBal());
                postingRequest.setAvailableBal(transactions.getAmount() + toAccount.getAvailableBal());
                postingRequest.setUpdateDate(LocalDateTime.now());

                toAccount = jpaQuery.postingTransaction(postingRequest);

                if (toAccount.getAccountNo() != null) {
                    response.setResponseCode(ResponseCodes.Success.getCode());
                    response.setResponseMessage(ResponseCodes.Success.getMessage());
                } else {
                    response.setResponseCode(ResponseCodes.Failed.getCode());
                    response.setResponseMessage(ResponseCodes.Failed.getMessage());
                }
            }else{
                response.setResponseCode(ResponseCodes.Failed.getCode());
                response.setResponseMessage(ResponseCodes.Failed.getMessage());
            }
        }catch(Exception ex){
            log.info("Withdrawal error: {}", ex);
            throw new GeneralExceptions(ResponseCodes.INTERNAL_SERVER_ERROR,ResponseCodes.INTERNAL_SERVER_ERROR.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
        }


        return response;
    }


    public Response InternalTransfer(Transactions transactions){

        log.info("Performing Internal transfer");
        Response response = new Response();

        Account toAccount =  new Account();
        Account fromAccount =  new Account();

        PostingRequest postingRequest = new PostingRequest();

        try{
        //Get balance
        fromAccount = accountRepository.findByAccountNo(transactions.getFromAccount());

        if(fromAccount.getWithrawableBal() < transactions.getAmount()){
            response.setResponseCode(ResponseCodes.INSUFFICIENT_BALANCE.getCode());
            response.setResponseMessage(ResponseCodes.INSUFFICIENT_BALANCE.getMessage());
            return response;
        }

        //from account
        postingRequest.setAccountNo(transactions.getFromAccount());
        postingRequest.setWithrawableBal(transactions.getAmount()-fromAccount.getWithrawableBal());
        postingRequest.setAvailableBal(transactions.getAmount()- fromAccount.getAvailableBal());
        postingRequest.setUpdateDate(LocalDateTime.now());

        fromAccount = jpaQuery.postingTransaction(postingRequest);

        //to account
        if(fromAccount != null) {
            toAccount = accountRepository.findByAccountNo(transactions.getToAccount());
            postingRequest.setAccountNo(transactions.getToAccount());
            postingRequest.setWithrawableBal(transactions.getAmount() + toAccount.getWithrawableBal());
            postingRequest.setAvailableBal(transactions.getAmount() + toAccount.getAvailableBal());
            postingRequest.setUpdateDate(LocalDateTime.now());

            toAccount = jpaQuery.postingTransaction(postingRequest);

            if (toAccount.getAccountNo() != null) {
                response.setResponseCode(ResponseCodes.Success.getCode());
                response.setResponseMessage(ResponseCodes.Success.getMessage());
            } else {
                response.setResponseCode(ResponseCodes.Failed.getCode());
                response.setResponseMessage(ResponseCodes.Failed.getMessage());
            }
        }else{
            response.setResponseCode(ResponseCodes.Failed.getCode());
            response.setResponseMessage(ResponseCodes.Failed.getMessage());
        }
        }catch(Exception ex){
            log.info("Internal transfer error: {}", ex);
            throw new GeneralExceptions(ResponseCodes.INTERNAL_SERVER_ERROR,ResponseCodes.INTERNAL_SERVER_ERROR.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
        }


        return response;
    }

    public static void main(String[] args) {
        double q = 0;
        double y = 10000;

        System.out.println(q-y);
    }
}
