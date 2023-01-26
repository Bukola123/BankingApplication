package com.bankApp.authentication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    @Column(nullable = false, unique = true, length = 45)
    private String dateOfBirth;
    @Column(nullable = false, unique = true, length = 20)
    private String firstName;
    private String middleName;
    @Column(nullable = false, unique = true, length = 20)
    private String lastName;
    @Column(nullable = false, unique = true, length = 20)
    private String address;
    @Column(nullable = false, unique = true, length = 20)
    private String email;
    @Column(nullable = false, unique = true, length = 20)
    private String phone;
    private LocalTime createDate ;
    private LocalTime updateDate ;


    @OneToOne(targetEntity = Account.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "accountId_fk", referencedColumnName = "accountId")
    private Account account;



}
