package com.bankApp.authentication.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//    @Column(nullable = false, length = 100)
//    private String userId;
    @Column(nullable = false, unique = true, length = 100)
    private String passport;

    @OneToOne(targetEntity = Document.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "utilityId_fk", referencedColumnName = "id")
//    @Column(nullable = false, length = 100)
    private Utility utility;

    @OneToOne(targetEntity = Document.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "IdCard_fk", referencedColumnName = "id")
//    @Column(nullable = false, length = 100)
    private IdDetails idCard;

    @Column(nullable = false, unique = true, length = 100)
    private String accountNo;
}
