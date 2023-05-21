package com.bankApp.dashboard.service.impli;

import com.bankApp.dashboard.dao.AccountRepository;
import com.bankApp.dashboard.model.Account;
import com.bankApp.dashboard.service.DashboardServiceInterf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardServiceImpl implements DashboardServiceInterf {

    @Autowired
    AccountRepository accountRepository;

    public Account getBalance(String accountno){
        return accountRepository.getBalanceByAcct(accountno);
    }
}
