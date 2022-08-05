package com.example.demo.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
//@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DashboardAccount {
    private Long accountId;
    private String accountName;
    private BigDecimal Balance;
    private String description;
    private Long contactNumber;
	public DashboardAccount(Long accountId, String accountName, BigDecimal balance, String description,
			Long contactNumber) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		Balance = balance;
		this.description = description;
		this.contactNumber = contactNumber;
	}
    
    
}
