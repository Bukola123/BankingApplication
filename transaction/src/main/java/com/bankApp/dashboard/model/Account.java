package com.bankApp.dashboard.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    private double availableBal;
    private double withrawableBal;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;


//    @OneToOne(targetEntity = Document.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "docId_fk", referencedColumnName = "id")
//    private Document document;
}
