package com.bankApp.admin.AccountTypeManagement.dto.request;


import com.bankApp.admin.AccountTypeManagement.model.AccountType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Accessors(chain = true)
public class CreateAccountType {

    @NotBlank(message = "Account type name can not be null")
    private String name;
//    @NotBlank(message = "Account min Deposit Value can not be null")
    @NotEmpty(message = "Account min Deposit Value can not be null")
    private double minDepositValue;
    @NotBlank(message = "Account max Deposit Value can not be null")
    private double maxDepositValue;
    @NotBlank(message = "Account min Withdraw Value can not be null")
    private double minWithdrawValue;
    @NotBlank(message = "Account max Withdraw Value can not be null")
    private double maxWithdrawValue;
}
