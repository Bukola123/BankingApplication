package com.bankApp.admin.accountManagement.controller;

import com.bankApp.admin.accountManagement.model.Account;
import com.bankApp.admin.accountManagement.model.User;
import com.bankApp.admin.accountManagement.service.UserManagementService;
import com.bankApp.admin.accountManagement.dto.request.UserRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
@Slf4j
public class AdminController {

    @Autowired
    UserManagementService userManagementService;


    @PostMapping(value = "/view/all")
    public List<User> getAllUsers(){
        return (userManagementService.getAllUsers());
    }

    @PostMapping(value = "/get/account")
    public User getByAccountNo(@RequestBody Account accountNo){
        User user = new User();
        user= userManagementService.findByAccount(accountNo);
        return (user);
    }

    @PostMapping(value = "/get/email")
    public User getByEmail(@RequestBody UserRequest userRequest){
        return (userManagementService.findByEmail(userRequest));
    }
}
