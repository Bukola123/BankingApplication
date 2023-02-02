package com.bankApp.admin.AccountTypeManagement.service;

import com.bankApp.admin.AccountTypeManagement.dto.request.CreateAccountType;
import com.bankApp.admin.AccountTypeManagement.model.AccountType;
import com.bankApp.admin.utils.Response;

public interface AccountTypeServiceInterface {
    Response createAccountType(CreateAccountType accountType);
}
