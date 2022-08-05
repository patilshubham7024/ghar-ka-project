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
public class Credit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "credit_id", nullable = false)
    private Long creditId;

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
    @JoinColumn(name = "accountId")
    private Account account;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "contactNumber")
    private Profile profile;

	public Long getCreditId() {
		return creditId;
	}

	public void setCreditId(Long creditId) {
		this.creditId = creditId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
}
