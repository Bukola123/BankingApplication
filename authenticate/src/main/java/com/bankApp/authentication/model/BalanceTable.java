package com.bankApp.authentication.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data

public class BalanceTable {
    @Id
    private String userId;
    private String accountNo;
    private int availableBal;
    private int withrawableBal;
}
