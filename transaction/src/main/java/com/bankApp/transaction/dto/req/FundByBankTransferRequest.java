package com.bankApp.transaction.dto.req;

import com.bankApp.transaction.model.Bank;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class FundByBankTransferRequest {

    @Value("callbackEmail")
    private String email ;  //The business email address
    private String amount; //Amount to fund
    private String bank;
    private String code; //Bank code associated to the bank with the account no
    private String account_number; //Account number use to fund
}
