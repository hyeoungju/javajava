package com.varxyz.jvx330.mvc.example6;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountCommand {
	private String accountNum;
	private char accType;
	private double balance;
	private double interestRate;
	private double overAmount;
}
