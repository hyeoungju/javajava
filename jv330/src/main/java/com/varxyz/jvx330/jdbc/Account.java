package com.varxyz.jvx330.jdbc;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Account {
	private long aid;
	private Customer customer;
	private long customerId;
	private String accountNum;
	private char accType;
	private double balance;
	private double interestRate;
	private double overAmount;
	private Date regDate;
	
	public Account() {
		
	}
}
