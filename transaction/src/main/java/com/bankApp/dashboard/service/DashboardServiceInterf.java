package com.bankApp.dashboard.service;

import com.bankApp.dashboard.model.Account;

public interface DashboardServiceInterf {
    public Account getBalance(String accountno);
}
