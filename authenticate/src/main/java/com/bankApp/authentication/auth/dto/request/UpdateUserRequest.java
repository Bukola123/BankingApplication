package com.bankApp.authentication.auth.dto.request;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Accessors(chain = true)
public class UpdateUserRequest {

    private Long userId;
    private String accountNo;
    private String email;
    private String phone;
    private String address;
    private LocalDateTime updateDate;


//    //Document
//    private String utilityType;
//    private String utilityAddress;
//    private String utilityImage;
//
//    //Id
//    private String idType;
//    private String idNumber;
//    private String idLocation;
//    private String idImage;
//    private String idSigned;
}
