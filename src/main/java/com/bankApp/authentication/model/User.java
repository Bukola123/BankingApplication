package com.bankApp.authentication.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
//    @OneToMany
//    private Account account;
    private String dateOfBirth;
    private String firstName;
    private String middleName;
    private String lastName;
    private String address;


}
