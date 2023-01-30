package com.bankApp.authentication.dto.request;


import com.bankApp.authentication.model.Account;
import com.bankApp.authentication.model.MobileBankingDetails;
import lombok.Data;

@Data
public class MobileAppRegRequest {
//    private Account account;
//    private MobileBankingDetails mobileBankingDetails;

    private String accountNo;
    private String password;

}
