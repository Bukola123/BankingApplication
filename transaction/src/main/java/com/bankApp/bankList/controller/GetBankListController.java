package com.bankApp.bankList.controller;


import com.bankApp.bankList.dto.response.GetBankListResponse;
import com.bankApp.bankList.service.GetBankListServiceInterface;
import com.bankApp.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "bank")
public class GetBankListController {

    @Autowired
    GetBankListServiceInterface getBankListServiceInterface;

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getBankList(@RequestParam String country){
        return getBankListServiceInterface.getBankList(country);
    }

//    @GetMapping(value = "/list", produces = MediaType.TEXT_PLAIN_VALUE)
//    public String getBankListEncrypt(@RequestParam String country){
//        return getBankListServiceInterface.getBankList(country);
//    }
}
