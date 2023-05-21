package com.bankApp.transaction.dto.req;

import com.bankApp.transaction.model.Bank;
import lombok.Data;

@Data
public class FundByBankTransferRequest {

    private String email;
    private String amount;
    private String bank;
    private String code;
    private String account_number;
}
