package com.bankApp.transaction.dto.req;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class FundByBankTransferRequest {

    @Value("callbackEmail")
    private String email ;  //The business email address
    private double amount; //Amount to fund
    private String bank;
    private String code; //Bank code associated to the bank with the account no
    private String source_account_number; //Account number use to fund
    private String birthday; //Account number use to fund
    private String fundAccount; //Account number use to fund
}
