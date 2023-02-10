package com.bankApp.authentication.auth.model;

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
    @Column(nullable = false, length = 45)
    private String dateOfBirth;
    @Column(nullable = false,  length = 20)
    private String firstName;
    private String middleName;
    @Column(nullable = false, length = 20)
    private String lastName;
    @Column(nullable = false, length = 20)
    private String address;  //To be validated by an external api
    @Column(nullable = false, unique = true, length = 100)
    private String email;
    @Column(nullable = false, unique = true, length = 20)
    private String phone;
    private LocalTime createDate ;
    private LocalTime updateDate ;

//    private String passport;  //To be saved on cloudinary or AWS S3
    @Column(nullable = false, unique = true, length = 100)
    private String bvn;


    @OneToOne(targetEntity = Account.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "accountId_fk", referencedColumnName = "id")
    private Account account;






}
