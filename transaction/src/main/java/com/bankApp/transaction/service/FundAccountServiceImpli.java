package com.bankApp.transaction.service;

import com.bankApp.transaction.dto.req.FundByBankTransferRequest;
import com.bankApp.transaction.model.Transactions;
import com.bankApp.transaction.repo.TransactionRepoInterface;
import com.bankApp.utils.JpaQuery;
import com.bankApp.utils.Response;
import com.bankApp.transaction.dto.response.FundByAccountResponse;
import com.bankApp.transaction.model.PaystackFundByAccount;
import com.bankApp.utils.exemptions.GeneralExceptions;
import com.bankApp.utils.general.enums.ResponseCodes;
import com.bankApp.utils.general.interfaces.Transformer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Collections;

import static com.bankApp.utils.UtilityService.generateNarration;


@Service
@Slf4j
@RequiredArgsConstructor
public class FundAccountServiceImpli implements FundAccountServiceInterface {

    @Autowired
    RestTemplate restTemplate;

    @Value("${paystackFundAccountUrl}")
    private String paystackAccountUrl;

    @Value("${paystackSecretKey}")
    private String paystackSecretKey;


    @Value("${paystackMock}")
    private Boolean mock;

    @Autowired
    private TransactionRepoInterface transactionRepoInterface;

    @Autowired
    private JpaQuery jpaQuery;

    @Autowired
    PostingServiceInterface postingServiceInterface;


    private final Transformer<FundByBankTransferRequest, PaystackFundByAccount> requestTransformer;

    public Response fundAccount(FundByBankTransferRequest request) {

        try {

            //Save transaction

            Transactions transactions = new Transactions();
            transactions.setFromAccount(request.getSource_account_number());
            transactions.setToAccount(request.getFundAccount());
            transactions.setAmount(request.getAmount());
            transactions.setTypeOfTransaction("DEPOSIT");
            transactions.setCreateDate(LocalDateTime.now());
            transactions.setStatus("Pending");
            Transactions transactions1 = transactionRepoInterface.save(transactions);

            if (transactions1.getTransId() == null)
                throw new GeneralExceptions(ResponseCodes.INTERNAL_SERVER_ERROR, ResponseCodes.INTERNAL_SERVER_ERROR.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);


            PaystackFundByAccount paystackFundByAccount = requestTransformer.transform(request);

            Response response = new Response();


            FundByAccountResponse.PaystackFundResponse2 response2 = null;

            if (mock) {
                FundByAccountResponse fundByAccountResponse = new FundByAccountResponse();
                response2 = new FundByAccountResponse.PaystackFundResponse2();
                fundByAccountResponse.setStatus("true");
                fundByAccountResponse.setMessage("Charge attempted");
                fundByAccountResponse.setPaystackFundResponse2(response2);
                response2.setStatus("send_birthday");
                response2.setReference("t6o6661t43304xc");
                response2.setDisplay_text("Please enter your birthday");


                //Update transaction
                transactions.setFromAccount(request.getSource_account_number());
                transactions.setToAccount(request.getFundAccount());
                transactions.setAmount(request.getAmount());
                transactions.setUpdateDate(LocalDateTime.now());
                transactions.setStatus(fundByAccountResponse.getMessage());
                transactions.setExternalId(response2.getReference());
                transactions.setNarration(generateNarration(request.getSource_account_number(), request.getFundAccount(), "Paystack", response2.getReference()));
                jpaQuery.updateTransaction(transactions);

                if (fundByAccountResponse.getStatus().equalsIgnoreCase("true")) {
                    transactions.setTypeOfTransaction("DEPOSIT");
                    response = postingServiceInterface.postingService(transactions);
                }



            }else {
                HttpHeaders requestHeaders = new HttpHeaders();
                requestHeaders.setContentType(MediaType.APPLICATION_JSON);
                requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
                requestHeaders.set("Authorization", "Bearer " + paystackSecretKey);
                requestHeaders.set("ConsistencyLevel", "eventual");
                requestHeaders.set("Accept", "application/json");


                HttpEntity<?> requestEntity = new HttpEntity<>(paystackFundByAccount, requestHeaders);

                log.info("UserDetailRequest  request {} : ", paystackFundByAccount);


                ResponseEntity<FundByAccountResponse> call = restTemplate.exchange(paystackAccountUrl, HttpMethod.POST, requestEntity, FundByAccountResponse.class);
                log.info("Response {}", call.getBody());


                //Update transaction
                transactions.setFromAccount(request.getSource_account_number());
                transactions.setToAccount(request.getFundAccount());
                transactions.setAmount(request.getAmount());
                transactions.setUpdateDate(LocalDateTime.now());
                transactions.setStatus(call.getBody().getMessage());
                transactions.setExternalId(call.getBody().getPaystackFundResponse2().getReference());
                transactions.setNarration(generateNarration(request.getSource_account_number(), request.getFundAccount(), "Paystack", call.getBody().getPaystackFundResponse2().getReference()));
                jpaQuery.updateTransaction(transactions);

                if (call.getBody().getStatus().equalsIgnoreCase("true")) {
                    transactions.setTypeOfTransaction("DEPOSIT");
                    response = postingServiceInterface.postingService(transactions);
                }


            }

            //Update transaction
            transactions.setUpdateDate(LocalDateTime.now());
            transactions.setStatus(response.getResponseMessage());
            jpaQuery.updateAfterPosting(transactions);

            log.info("Final response {}", response);
            return response;

        } catch (Exception exception) {
            log.info("Exception {}", exception);
            throw new GeneralExceptions(ResponseCodes.INTERNAL_SERVER_ERROR,ResponseCodes.INTERNAL_SERVER_ERROR.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
