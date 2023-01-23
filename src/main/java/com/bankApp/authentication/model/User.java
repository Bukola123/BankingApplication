package com.bankApp.authentication.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String dateOfBirth;
    private String firstName;
    private String middleName;
    private String lastName;
    private String address;
    private String email;
    private String phone;
    private LocalTime createDate ;
    private LocalTime updateDate ;


    @OneToOne(targetEntity = Account.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "accountId_fk", referencedColumnName = "accountId")
    private Account account;



}
