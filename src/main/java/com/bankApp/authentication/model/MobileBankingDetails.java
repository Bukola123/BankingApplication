package com.bankApp.authentication.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class MobileBankingDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;
    private String username;
    private String password;
}


