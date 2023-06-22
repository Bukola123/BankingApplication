package com.bankApp.transaction.dto.response;

import lombok.Data;

@Data
public class FundByAccountResponse {

//    {
//        "status": true,
//            "message": "Charge attempted",
//            "data": {
//        "reference": "z8q981z5kp7sfde",
//                "status": "pending",
//                "display_text": "Processing transaction"
//    }
//    }

    private String status;
    private String message;
    private PaystackFundResponse2 paystackFundResponse2;

    @lombok.Data
    public static class PaystackFundResponse2 {
        private  String reference;
        private String status;
        private String display_text;
    }

}
