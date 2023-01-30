package com.bankApp.authentication.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class MobileBankingDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, unique = true, length = 100)
    private Long userId;
    @Column(nullable = false, unique = true, length = 100)
    private String email;
    @Column(nullable = false,length = 100)
    private String password;
    private Integer pin;
}


