package com.bankApp.admin.AccountTypeManagement.controller;


import com.bankApp.admin.AccountTypeManagement.dto.request.CreateAccountType;
import com.bankApp.admin.AccountTypeManagement.service.AccountTypeServiceInterface;
import com.bankApp.admin.accountManagement.model.User;
import com.bankApp.admin.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/accountype")
@RequiredArgsConstructor
public class AccounTypeController {

    @Autowired
    AccountTypeServiceInterface accountTypeServiceInterface;

    @PostMapping(value = "/create")
    public Response createAccountType(@RequestBody CreateAccountType createAccountType){
        return (accountTypeServiceInterface.createAccountType(createAccountType));
    }
}
