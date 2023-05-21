package com.bankApp.transaction.dto.req;

import com.bankApp.transaction.model.Bank;
import lombok.Data;

@Data
public class FundByBankTransferRequest {

    private String email;  //Email associated with the account
    private String amount; //Amount to fund
    private String bank;
    private String code; //Bank code associated to the bank with the account no
    private String account_number; //Account number use to fund
}
