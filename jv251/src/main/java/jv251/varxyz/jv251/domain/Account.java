package jv251.varxyz.jv251.domain;

import java.util.Date;
import java.sql.Timestamp;

/**
 * 
 * @author Administrator
 *
 */
public class Account{
	private long aid;
	
	public char getAccountType() {
		return accountType;
	}

	public void setAccountType(char accountType) {
		this.accountType = accountType;
	}

	public long getAid() {
		return aid;
	}

	protected String accountNum;
	protected double balance;
	protected Customer customer; //account가 customer를 참조한다.
	protected Date regDate;
	private char accountType;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}
	
	public Account(String accountNum2, double balance) {
		this.accountNum = accountNum;
		this.balance = balance;
	}
	
	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date date) {
		this.regDate = date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void deposite(double amount) {
		this.balance += amount;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setAid(long long1) {
		// TODO Auto-generated method stub
		
	}

	public void setAccountType(String string) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString() {
		return accountNum + balance + accountType + regDate;
	}
}
