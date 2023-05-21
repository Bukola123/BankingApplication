package com.bankApp.dashboard.controller;

import com.bankApp.dashboard.model.Account;
import com.bankApp.dashboard.service.DashboardServiceInterf;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user/dashboard")
@Slf4j
public class DashboardController {

    @Autowired
    DashboardServiceInterf dashboardServiceInterf;

    @GetMapping(value = "/balance")
    public Account getBalance(@RequestParam String accountno){
        log.info("Request {}", accountno);
        return dashboardServiceInterf.getBalance(accountno);
    }
}
