package com.bankApp.authentication.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
    private String accountNo;
    private String accountType;
}
