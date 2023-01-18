package com.bankApp.authentication.service;

import com.bankApp.authentication.dto.request.CreateUserRequest;
import com.bankApp.authentication.utils.Response;

public interface CreateUserService {
    public Response createUser(CreateUserRequest createUserRequest);
}
