package com.bankApp.transaction.service;

import com.bankApp.transaction.dto.req.FundByBankTransferRequest;
import com.bankApp.utils.Response;
import com.bankApp.transaction.dto.response.FundByAccountResponse;
import com.bankApp.transaction.model.PaystackFundByAccount;
import com.bankApp.utils.exemptions.GeneralExceptions;
import com.bankApp.utils.general.enums.ResponseCodes;
import com.bankApp.utils.general.interfaces.Transformer;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;


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

    private final Transformer<FundByBankTransferRequest, PaystackFundByAccount> requestTransformer;

    public Response fundAccount(FundByBankTransferRequest request) {

        try {



            PaystackFundByAccount paystackFundByAccount = requestTransformer.transform(request);

            Response response = new Response();
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

            if (call.getBody() != null) {
                response.setResponseCode("000");
                response.setResponseMessage("Funding successful");
                response.setData(call.getBody());
            } else {
                response.setResponseCode("999");
                response.setResponseMessage("Funding Failed");
            }
            return response;

        } catch (Exception exception) {
            log.info("Exception {}", exception);
            throw new GeneralExceptions("99","Internal server error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
