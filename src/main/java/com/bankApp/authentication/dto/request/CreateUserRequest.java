package com.bankApp.authentication.dto.request;

import com.bankApp.authentication.model.Account;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Accessors(chain = true)
public class CreateUserRequest {

//    private Account account;
    private String dateOfBirth;
    private String firstName;
    private String middleName;
    private String lastName;
    private String address;
}
