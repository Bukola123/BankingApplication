package com.bankApp.authentication.controller;

import com.bankApp.authentication.dto.request.CreateUserRequest;
import com.bankApp.authentication.model.User;
import com.bankApp.authentication.service.CreateUserService;
import com.bankApp.authentication.utils.Response;
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
public class UserController {

    @Autowired
    CreateUserService createUserService;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public Response createUser(@RequestBody CreateUserRequest createUserRequest){
        return (createUserService.createUser(createUserRequest));
    }

    @PostMapping(value = "/mobile/register", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public Response mobileUserRegistration(@RequestBody CreateUserRequest createUserRequest){
        return (createUserService.createUser(createUserRequest));
    }

    @PostMapping(value = "view/all")
    public List<User> getAllUsers(){
        return (createUserService.getAllUsers());
    }
}
