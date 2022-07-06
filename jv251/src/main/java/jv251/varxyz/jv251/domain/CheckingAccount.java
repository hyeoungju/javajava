package jv251.varxyz.jv251.domain;

import jv251.varxyz.jv251.exception.OverdraftException;

public class CheckingAccount extends Account{
	private double overdraftAmount;
	
	public CheckingAccount() {
		// TODO Auto-generated constructor stub
	}
	
	public CheckingAccount(String accountNum, double balance, double overdraftAmount) {
		super(accountNum, balance);
		this.overdraftAmount = overdraftAmount;
	}

	public void withdraw(double amount) {
		if(balance < amount) {
			//잔고부족시 overdraftAmount 금액을 한도 내에서 추가 출금을 승인
			double overdraftNeeded = amount - balance;
			if (overdraftAmount < overdraftNeeded) {
				throw new OverdraftException("에러 : 대월금 초과", balance, overdraftNeeded);
			}else {
				balance = 0.0;
				overdraftAmount = overdraftAmount - overdraftNeeded;
			}
		}else {
			balance = balance - amount;
		}
	}

	//입금로직구현하기 deposit
	public void deposit(double amount) {
		super.balance += amount;
	}
	
	public double getOverdraftAmont() {
		return overdraftAmount;
	}

	public void setOverdraftAmount(double overdraftAmount) {
		this.overdraftAmount = overdraftAmount;
	}

	public void setAccountType(char ca) {
		// TODO Auto-generated method stub
		
	}
}
