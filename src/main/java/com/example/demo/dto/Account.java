package com.example.demo.dto;

import com.example.demo.enums.RecordStatus;
import com.sun.istack.NotNull;
import lombok.*;

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
    @Column(name = "account_id")
    private Long accountId;

    @Column
    private String accountName;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "contactNumber")
    private Profile profile;

    @Column
    @NotNull
    private BigDecimal amount;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "account")
    private List<Credit> credit;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "account")
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

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public List<Credit> getCredit() {
        return credit;
    }

    public void setCredit(List<Credit> credit) {
        this.credit = credit;
    }

    public List<Expense> getExpense() {
        return expense;
    }

    public void setExpense(List<Expense> expense) {
        this.expense = expense;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getRecordCreatedBy() {
        return recordCreatedBy;
    }

    public void setRecordCreatedBy(Long recordCreatedBy) {
        this.recordCreatedBy = recordCreatedBy;
    }

    public LocalDateTime getRecordCreatedDate() {
        return recordCreatedDate;
    }

    public void setRecordCreatedDate(LocalDateTime recordCreatedDate) {
        this.recordCreatedDate = recordCreatedDate;
    }

    public Long getRecordUpdatedBy() {
        return recordUpdatedBy;
    }

    public void setRecordUpdatedBy(Long recordUpdatedBy) {
        this.recordUpdatedBy = recordUpdatedBy;
    }

    public LocalDateTime getRecordUpdatedDate() {
        return recordUpdatedDate;
    }

    public void setRecordUpdatedDate(LocalDateTime recordUpdatedDate) {
        this.recordUpdatedDate = recordUpdatedDate;
    }

    public RecordStatus getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(RecordStatus recordStatus) {
        this.recordStatus = recordStatus;
    }
}
