package com.example.demo.dto;

import com.example.demo.enums.RecordStatus;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Expense implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entity_id", nullable = false)
    private Long entityId;

    @Column
    @NotNull
    private BigDecimal amount;

    @Column
    @NotNull
    private LocalDateTime transactionDate;

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

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;
}
