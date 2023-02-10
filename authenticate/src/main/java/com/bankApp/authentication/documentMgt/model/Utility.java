package com.bankApp.authentication.documentMgt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Utility {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, length = 100)
    private String utilityType;
    @Column(nullable = false, length = 100)
    private String utilityAddress;
    private String utilityStatus;
    private String verifiedBy;
    private String approvedBy;
    private String cloudinary;
    private String utilityComment;
    private String accountNo;
}
