package jv251.varxyz.jv251.service;

import java.util.List;

import com.google.protobuf.Service;

import jv251.varxyz.jv251.dao.AccountDao;
import jv251.varxyz.jv251.dao.CustomerDao;
import jv251.varxyz.jv251.domain.Account;
import jv251.varxyz.jv251.domain.CheckingAccount;
import jv251.varxyz.jv251.domain.Customer;
import jv251.varxyz.jv251.domain.SavingsAccount;
import jv251.varxyz.jv251.exception.CustomerNotFoundException;
import jv251.varxyz.jv251.exception.DuplicatedEntityException;
import jv251.varxyz.jv251.exception.EntityNotFoundException;

public class BankService {
	private static final BankService service = new BankService();
	public static final char SA = 'S';
	public static final char CA = 'C';
	
	public static final double DEFAULT_INEREST_RATE = 0.03;
	public static final double DEFAULT_OVERDRAFT_AMOUNT = 1000.0;
	
	private CustomerService customerService;
	private AccountService accountService;
	
	private BankService() {
		init();
	}
	
	public void init() {
		customerService = new CustomerService(new CustomerDao());
		accountService = new AccountService(new AccountDao());
	}
	
	public static BankService getInstance() {
		return service;
	}
	
	public void addCustomer(String name, String ssn, String phone, String userId, String passwd) {
		if(!isCustomer(ssn)) {
			customerService.addCustomer(customerService.createCustomer(name, ssn, phone, userId, passwd));
		} else {
			throw new DuplicatedEntityException(ssn + "is duplicated.");			
		}
	}
	
	public Customer getCustomerBySsn(String ssn) {
		return customerService.getCustomerBySsn(ssn);
	}
	
	public List<Customer> getAllCustoemrs() {
		return customerService.getAllCustomer();
	}
	
	public void addSanvingsAccount(double balance, double interestRate, String ssn) 
									throws EntityNotFoundException {
		SavingsAccount account = new SavingsAccount();
		account.setAccountNum(accountService.generateAccountNum());
		account.setBalance(balance);
		account.setAccountType(BankService.SA);
		account.setInterestRate(interestRate);
		Customer customer = customerService.getCustomerBySsn(ssn);
		if(customer != null) {
			account.setCustomer(customer);
			accountService.addAccount(account);
		}else {
			throw new EntityNotFoundException(ssn + "not found.");
		}
		account.setCustomer(customer);
	}
	
	public void addCheckingAccount(double balance, double overdraftAmount, String ssn)
									throws CustomerNotFoundException {
		CheckingAccount account = new CheckingAccount();
		account.setAccountNum(accountService.generateAccountNum());
		account.setBalance(balance);
		account.setAccountType(BankService.CA);
		account.setOverdraftAmount(overdraftAmount);
		
		Customer customer = customerService.getCustomerBySsn(ssn);
		if(customer != null) {
			account.setCustomer(customer);
			accountService.addAccount(account);
		}else {
			throw new CustomerNotFoundException(ssn + "not found.");
		}
	}
	
	public boolean isCustomer(String ssn) {
		return customerService.getCustomerBySsn(ssn) == null ? false : true;
	}
	
	public List<Account> getAccountBySsn(String ssn) {
		return accountService.getAccountBySsn(ssn);
	}
	
	public void withDraw(double amount, String accountNum) {
		// 1. 계좌번호로 객체생성했으니까 이게 s, c인지 찾기
		// 2. 다운캐스팅을 해서 withdraw 메서드 사용하여 balance값 업데이트
		// 3. 데이터베이스에 balance값 업데이트
		Account account = accountService.getAccountsByAccountNum(accountNum);
		if(account.getAccountType() == 'S') {
			((SavingsAccount)account).withdraw(amount);
			accountService.getUpdateAccount(account, accountNum);
		}else {
			((CheckingAccount)account).withdraw(amount);
			accountService.getUpdateAccount(account, accountNum);
		}
	}
	
}
