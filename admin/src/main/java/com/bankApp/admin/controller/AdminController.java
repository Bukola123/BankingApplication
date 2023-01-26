package com.bankApp.admin.controller;

import com.bankApp.admin.dto.request.UserRequest;
import com.bankApp.admin.model.Account;
import com.bankApp.admin.model.User;
import com.bankApp.admin.service.UserManagementService;
import com.bankApp.admin.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class AdminController {

    @Autowired
    UserManagementService userManagementService;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public Response createUser(@RequestBody UserRequest userRequest){
        return (userManagementService.createUser(userRequest));
    }

    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public Response updateUser(@RequestBody UserRequest userRequest){
        return (userManagementService.updateUser(userRequest));
    }

    @PostMapping(value = "/mobile/register", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public Response mobileUserRegistration(@RequestBody UserRequest userRequest){
        return (userManagementService.createUser(userRequest));
    }

    @PostMapping(value = "/view/all")
    public List<User> getAllUsers(){
        return (userManagementService.getAllUsers());
    }


    @PostMapping(value = "/get/account")
    public User getByAccountNo(@RequestBody Account accountNo){
        return (userManagementService.findByAccount(accountNo));
    }

    @PostMapping(value = "/get/email")
    public User getByEmail(@RequestBody UserRequest userRequest){
        return (userManagementService.findByEmail(userRequest));
    }
}
