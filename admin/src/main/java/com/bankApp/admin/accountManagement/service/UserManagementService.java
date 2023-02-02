package com.bankApp.admin.accountManagement.service;

import com.bankApp.admin.accountManagement.dto.request.UserRequest;
import com.bankApp.admin.accountManagement.model.Account;
import com.bankApp.admin.accountManagement.model.User;
import com.bankApp.admin.utils.Response;

import java.util.List;

public interface UserManagementService {
    public Response createUser(UserRequest createUserRequest);
    public Response updateUser(UserRequest createUserRequest);

    public List<User> getAllUsers();
//    public User findByAccount(Account accountNo);
    public User findByAccount(Account account);

    public User findByEmail(UserRequest createUserRequest);
}
