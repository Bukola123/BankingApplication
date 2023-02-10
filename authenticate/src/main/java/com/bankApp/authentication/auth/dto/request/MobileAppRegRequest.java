package com.bankApp.authentication.auth.dto.request;


import lombok.Data;

@Data
public class MobileAppRegRequest {
//    private Account account;
//    private MobileBankingDetails mobileBankingDetails;

    private String accountNo;
    private String password;

}
