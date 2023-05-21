package com.bankApp.transaction.model;

import lombok.Data;

@Data
public class Bank {
    //            "bank": {
//        "code": "057",
//                "account_number": "0000000000"
//    }

    private String bank;
    private String code;
    private String account_number;
}
