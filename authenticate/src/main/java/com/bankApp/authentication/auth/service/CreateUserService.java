package com.bankApp.authentication.auth.service;

import com.bankApp.authentication.auth.dto.request.CreateUserRequest;
import com.bankApp.authentication.auth.dto.request.LoginUserRequest;
import com.bankApp.authentication.auth.dto.request.MobileAppRegRequest;
import com.bankApp.authentication.auth.dto.request.UpdateUserRequest;
import com.bankApp.authentication.auth.model.Account;
import com.bankApp.authentication.auth.model.User;
import com.bankApp.authentication.utils.Response;
import org.springframework.web.multipart.MultipartFile;

public interface CreateUserService {
    public Response createUser(CreateUserRequest createUserRequest);
    public Response updateUser(UpdateUserRequest createUserRequest);

    public User findByAccount(Account accountNo);

//    public User findByEmail(CreateUserRequest createUserRequest);

    public Response mobileAppReg(MobileAppRegRequest mobileAppRegRequest);
    public Response loginUser(LoginUserRequest loginUserRequest);
}
