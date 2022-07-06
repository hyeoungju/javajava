package jv251.varxyz.jv251.domain;

import java.util.Date;

import jv251.varxyz.jv251.exception.InsufficientBalanceException;

public class SavingsAccount extends Account {
	private double interestRate;
	
	public SavingsAccount() {
		
	}
	
	public SavingsAccount(String accountNum, double balance) {
		this(accountNum, balance, 0.0);
	}
	
	public SavingsAccount(String accountNum, double balance, double interestRate) {
		super(accountNum, balance);
		this.interestRate = interestRate;
	}
	

	public void withdraw(double amount) {
		if(balance - amount < 0) {
			//잔고 부족 예외발생
			throw new InsufficientBalanceException("잔고부족");
		}
		super.balance -= amount;
	}

	//deposit
	public void deposit(double amount) {
		super.balance += amount;
	}
	
	public double getInterestRate() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setInterestRate() {
		// TODO Auto-generated method stub
		
	}

	public void setInterestRate(double d) {
		// TODO Auto-generated method stub
		
	}

	public void setAccountType(char sa) {
		// TODO Auto-generated method stub
		
	}

}
