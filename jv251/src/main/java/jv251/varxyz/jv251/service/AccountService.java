package jv251.varxyz.jv251.service;

import java.util.List;

import jv251.varxyz.jv251.dao.AccountDao;
import jv251.varxyz.jv251.domain.Account;

public class AccountService {
	private AccountDao accountDao;
	
	public void addAccount(Account account) {
		accountDao.addAccount(account);
	}
	
	public AccountService(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	
	public static void main(String[] args) {
		AccountService service = new AccountService(null);
		System.out.println(service.generateAccountNum());
	}
	
	public List<Account> getAccountBySsn(String ssn) {
		return accountDao.findAccountsBySsn(ssn);
	}
	
	public Account getAccountsByAccountNum(String accountNum) {
		return accountDao.findAccountsByAccountNum(accountNum);
	}
	
	public void getUpdateAccount(Account account, String accountNum) {
		accountDao.updateAccount(account, accountNum);
	}
	
	/**
	 * xxx-xx-xxxx 형식의 계좌번호 생성기를 만드시오
	 * 
	 * @return
	 */
	public String generateAccountNum() {
		String numStr = String.valueOf((int)(Math.random() * 100000000));
		StringBuilder sb = new StringBuilder();
		sb.append(numStr.substring(0, 3));
		sb.append("-");
		sb.append(numStr.substring(3, 5));
		sb.append("-");
		sb.append(numStr.substring(5));
		return sb.toString();
	}
}
