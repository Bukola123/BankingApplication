package com.bankApp.transaction.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long TransId;
    @Column(nullable = false)
    private String from;
    @Column(nullable = false)
    private String to;

    @Column(nullable = false)
    private double amount;
    @Column(nullable = false)
    private String narration;

    private LocalDateTime date = LocalDateTime.now();
}
