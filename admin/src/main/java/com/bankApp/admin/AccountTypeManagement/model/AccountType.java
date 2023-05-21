package com.bankApp.admin.AccountTypeManagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false,unique = true, length = 45)
    private String name;
    @Column(nullable = false, length = 45)
    private double minDepositValue;
    @Column(nullable = false, length = 45)
    private double maxDepositValue;
    @Column(nullable = false, length = 45)
    private double minWithdrawValue;
    @Column(nullable = false, length = 45)
    private double maxWithdrawValue;
}
