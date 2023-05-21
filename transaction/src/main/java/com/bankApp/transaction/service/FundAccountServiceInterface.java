package com.bankApp.transaction.service;

import com.bankApp.transaction.dto.req.FundByBankTransferRequest;
import com.bankApp.utils.Response;
import com.bankApp.transaction.model.PaystackFundByAccount;

public interface FundAccountServiceInterface {
    public Response fundAccount(FundByBankTransferRequest paystackFundByAccount);
}
