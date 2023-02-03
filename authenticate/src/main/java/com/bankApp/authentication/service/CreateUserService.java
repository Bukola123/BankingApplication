package com.bankApp.authentication.service;

import com.bankApp.authentication.dto.request.CreateUserRequest;
import com.bankApp.authentication.dto.request.LoginUserRequest;
import com.bankApp.authentication.dto.request.MobileAppRegRequest;
import com.bankApp.authentication.model.Account;
import com.bankApp.authentication.model.User;
import com.bankApp.authentication.utils.Response;

import java.util.List;

public interface CreateUserService {
    public Response createUser(CreateUserRequest createUserRequest);
    public Response updateUser(CreateUserRequest createUserRequest);

    public User findByAccount(Account accountNo);

//    public User findByEmail(CreateUserRequest createUserRequest);

    public Response mobileAppReg(MobileAppRegRequest mobileAppRegRequest);
    public Response loginUser(LoginUserRequest loginUserRequest);
}
