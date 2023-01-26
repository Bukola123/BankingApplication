package com.bankApp.admin.service;

import com.bankApp.admin.dto.request.UserRequest;
import com.bankApp.admin.model.Account;
import com.bankApp.admin.model.User;
import com.bankApp.admin.utils.Response;

import java.util.List;

public interface UserManagementService {
    public Response createUser(UserRequest createUserRequest);
    public Response updateUser(UserRequest createUserRequest);

    public List<User> getAllUsers();
    public User findByAccount(Account accountNo);

    public User findByEmail(UserRequest createUserRequest);
}
