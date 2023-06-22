package com.bankApp.transaction.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostingRequest {

    private String accountNo;
    private String transactionType;
    private double availableBal;
    private double withrawableBal;
    private LocalDateTime updateDate;
}
