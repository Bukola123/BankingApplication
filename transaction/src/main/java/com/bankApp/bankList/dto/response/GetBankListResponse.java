package com.bankApp.bankList.dto.response;


import lombok.Data;

import java.util.List;

@Data
public class GetBankListResponse {

//    {
//        "status": true,
//            "message": "Banks retrieved",
//            "data": [
//        {
//            "name": "Abbey Mortgage Bank",
//                "slug": "abbey-mortgage-bank",
//                "code": "801",
//                "longcode": "",
//                "gateway": null,
//                "pay_with_bank": false,
//                "active": true,
//                "is_deleted": false,
//                "country": "Nigeria",
//                "currency": "NGN",
//                "type": "nuban",
//                "id": 174,
//                "createdAt": "2020-12-07T16:19:09.000Z",
//                "updatedAt": "2020-12-07T16:19:19.000Z"
//        },

    private String status;
    private String message;
    private List<BankList> data;


    @Data
    public class BankList {
        private String name;
        private String slug;
        private String code;
        private String longcode;
        private String gateway;
        private String pay_with_bank;
        private String active;
        private String is_deleted;
        private String country;
        private String currency;
        private String type;
        private String id;
        private String createdAt;
        private String updatedAt;
    }
}
