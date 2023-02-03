package com.bankApp.authentication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//    @Column(nullable = false, length = 100)
//    private String userId;
    private String idType;
    private String idNumber;
    private String idSigned;
    private String iDLocation;
    private String idStatus;
    private String verifiedBy;
    private String approvedBy;
    private String cloudinary;
    private String dateVerified;
    private String idComment;
    private String accountNo;
}
