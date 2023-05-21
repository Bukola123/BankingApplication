package com.bankApp.authentication.auth.model;

import com.bankApp.authentication.documentMgt.model.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, unique = true, length = 100)
    private String accountNo;
    private String accountType;
    private int availableBal;
    private int withrawableBal;
    private LocalTime createDate;
    private LocalTime updateDate;


//    @OneToOne(targetEntity = Document.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "docId_fk", referencedColumnName = "id")
//    private Document document;
}
