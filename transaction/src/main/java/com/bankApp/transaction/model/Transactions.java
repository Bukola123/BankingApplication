package com.bankApp.transaction.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transId;

    @Column(nullable = false)
    private String fromAccount;

    @Column(nullable = false)
    private String toAccount;

    @Column(nullable = false)
    private double amount;

    private String narration;


    @Column(nullable = false)
    private String status;

    private String externalId;
    private String typeOfTransaction;

    @Column(nullable = false)
    private LocalDateTime createDate;
    private LocalDateTime updateDate ;
}
