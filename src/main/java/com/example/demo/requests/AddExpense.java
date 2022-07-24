package com.example.demo.requests;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class AddExpense implements Serializable {

    private BigDecimal amount;
    private LocalDateTime transactionDate;
    private String description;
    private Long accountId;
    private Long contactNumber;
}
