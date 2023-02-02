package com.bankApp.admin.accountManagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long accountId;
    private Long id;
    private String accountNo;
    private String accountType;
    private LocalTime createDate;
    private LocalTime updateDate;
}
