package com.bankApp.admin.AccountTypeManagement.service.impli;

import com.bankApp.admin.AccountTypeManagement.dto.request.CreateAccountType;
import com.bankApp.admin.AccountTypeManagement.model.AccountType;
import com.bankApp.admin.AccountTypeManagement.repo.AccountTypeRepo;
import com.bankApp.admin.AccountTypeManagement.service.AccountTypeServiceInterface;
import com.bankApp.admin.utils.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountTypeTypeServiceImpl implements AccountTypeServiceInterface {
    @Autowired
    AccountTypeRepo accountTypeRepo;

    @Override
    public Response createAccountType(CreateAccountType request) {
//        if(request.getName() == null || request.getMaxDepositValue() == null || request.getMinDepositValue() == null){
//
//        }
        log.info("Request {}", request);
        Response response = new Response();
        ModelMapper modelMapper = new ModelMapper();
        AccountType accountType  = modelMapper.map(request,AccountType.class);
        accountTypeRepo.save(accountType);
        if(accountType.getId() == null){
            response.setResponseCode("99");
            response.setResponseMessage("Account type creation failed");
        }
        response.setResponseCode("00");
        response.setResponseMessage("Account type creation successful");
        return response;
    }
}
