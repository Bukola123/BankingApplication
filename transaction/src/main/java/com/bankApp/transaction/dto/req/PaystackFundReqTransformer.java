package com.bankApp.transaction.dto.req;

import com.bankApp.transaction.model.Bank;
import com.bankApp.transaction.model.PaystackFundByAccount;
import com.bankApp.utils.general.interfaces.Transformer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class PaystackFundReqTransformer implements Transformer<FundByBankTransferRequest, PaystackFundByAccount> {


    public PaystackFundByAccount transform(FundByBankTransferRequest fundByBankTransferRequest) {

        PaystackFundByAccount paystackFundByAccount = new PaystackFundByAccount();
        paystackFundByAccount.setEmail(fundByBankTransferRequest.getEmail());
        paystackFundByAccount.setAmount(String.valueOf(fundByBankTransferRequest.getAmount()));
        Bank bank = new Bank();

        bank.setAccount_number(fundByBankTransferRequest.getSource_account_number());
        bank.setBank(fundByBankTransferRequest.getBank());
        bank.setCode(fundByBankTransferRequest.getCode());

        paystackFundByAccount.setBank(bank);

        return paystackFundByAccount;
    }
}
