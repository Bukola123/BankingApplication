package com.bankApp.authentication.auth.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Accessors(chain = true)
public class CreateUserRequest {

    private String dateOfBirth;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String accountType;
    private String bvn;
    private String passport;


//Document
    private String utilityType;
    private String utilityAddress;
    private String utilityImage;

    //Id
    private String idType;
    private String idNumber;
    private String idLocation;
    private String idImage;
    private String idSigned;

}
