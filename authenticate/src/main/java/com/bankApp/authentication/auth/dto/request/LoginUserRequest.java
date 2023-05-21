package com.bankApp.authentication.auth.dto.request;


import lombok.Data;

@Data
public class LoginUserRequest {
    private String userName;
    private String password;
}
