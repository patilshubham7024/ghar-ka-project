package com.example.demo.dto;

import com.example.demo.enums.RecordStatus;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id", nullable = false)
    private Long accountId;

    @Column
    @NotNull
    private BigDecimal amount;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "credit_id")
    private List<Credit> credit;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "expense_id")
    private List<Expense> expense;

    @Column
    private String description;

    @Column
    private Long recordCreatedBy;
    @Column
    private LocalDateTime recordCreatedDate;
    @Column
    private Long recordUpdatedBy;
    @Column
    private LocalDateTime recordUpdatedDate;
    @Column(name = "record_status", columnDefinition="int default 1" )
    private RecordStatus recordStatus;

}
