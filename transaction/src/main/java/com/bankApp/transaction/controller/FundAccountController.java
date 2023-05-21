package com.bankApp.transaction.controller;


import com.bankApp.transaction.dto.req.FundByBankTransferRequest;
import com.bankApp.utils.Response;
import com.bankApp.transaction.model.PaystackFundByAccount;
import com.bankApp.transaction.service.FundAccountServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user/fund")
@Slf4j
public class FundAccountController {

    @Autowired
    FundAccountServiceInterface fundAccountServiceInterface;

    public void fundByCard(){
        //Using paystack, interswitch, flutterwave, remita and other payment gateways
    }

    @PostMapping(value = "account")
    public Response fundByBankTransfer(@RequestBody FundByBankTransferRequest request){
        //Using paystack, interswitch, flutterwave, remita and other payment gateways
        log.info("Request {}", request);
        return fundAccountServiceInterface.fundAccount(request);
    }
}
