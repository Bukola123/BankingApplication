package com.bankApp.authentication.controller;

import com.bankApp.authentication.dto.request.CreateUserRequest;
import com.bankApp.authentication.dto.request.MobileAppRegRequest;
import com.bankApp.authentication.model.Account;
import com.bankApp.authentication.model.User;
import com.bankApp.authentication.service.CreateUserService;
import com.bankApp.authentication.utils.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    @Autowired
    CreateUserService createUserService;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public Response createUser(@RequestBody CreateUserRequest createUserRequest){
        return (createUserService.createUser(createUserRequest));
    }

    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public Response updateUser(@RequestBody CreateUserRequest createUserRequest){
        return (createUserService.updateUser(createUserRequest));
    }

    @PostMapping(value = "/mobile/register", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public Response mobileUserRegistration(@RequestBody MobileAppRegRequest mobileAppRegRequest){
        return (createUserService.mobileAppReg(mobileAppRegRequest));
    }


    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public Response loginUser(@RequestBody CreateUserRequest createUserRequest){
        return (createUserService.createUser(createUserRequest));
    }


    @PostMapping(value = "/get/account")
    public User getByAccountNo(@RequestBody Account accountNo){
        User user = new User();
        user= createUserService.findByAccount(accountNo);
        return (user);
    }




}
