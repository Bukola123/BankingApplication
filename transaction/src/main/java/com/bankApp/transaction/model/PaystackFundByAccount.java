package com.bankApp.transaction.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaystackFundByAccount {

//    curl https://api.paystack.co/charge
//            -H "Authorization: Bearer YOUR_SECRET_KEY"
//            -H "Content-Type: application/json"
//            -d '{ "email": "customer@email.com",
//            "amount": "10000",
//            "bank": {
//        "code": "057",
//                "account_number": "0000000000"
//    }
//}'
//        -X POST

    private String email;
    private String amount;
    private String birthday;
    private Bank bank;
}
