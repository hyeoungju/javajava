package jv251.varxyz.jv251.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jv251.varxyz.jv251.domain.Account;
import jv251.varxyz.jv251.domain.CheckingAccount;
import jv251.varxyz.jv251.domain.Customer;
import jv251.varxyz.jv251.domain.SavingsAccount;

public class AccountDao {
	
	public AccountDao() {

	}
	
	public void addAccount(Account account) {
		String sql = "INSERT INTO Account(accountNum, balance, interestRate,"
				+ "overdraft, accountType, customerId)"
				+ "VALUES(?,?,?,?,?,?)";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = DataSourceManager.getConnetion();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, account.getAccountNum());;
				pstmt.setDouble(2, account.getBalance());
				if(account instanceof SavingsAccount) {
					SavingsAccount sa = (SavingsAccount)account;
					pstmt.setDouble(3, sa.getInterestRate());
					pstmt.setLong(4, (long) 0.0);
					pstmt.setString(5, String.valueOf('S'));
				}else {
					CheckingAccount ca = (CheckingAccount)account;
					pstmt.setDouble(3, 0.0);
					pstmt.setDouble(4, ca.getOverdraftAmont());
					pstmt.setString(5, String.valueOf('C'));
				}
				pstmt.setLong(6, account.getCustomer().getCid());
				pstmt.executeUpdate();
			}finally {
				DataSourceManager.close(rs,pstmt,con);	
			}
			
			System.out.println("NEW ACCOUNT INSERTED.....");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 전달된 주민번호를 가진 특정 고객의 계좌 목록 조회
	 * @param ssn			주민번호
	 * @return
	 */
	public List<Account> findAccountsBySsn(String ssn) {
		String sql = "SELECT a.aid ,a.accountNum, a.balance, a.interestRate,"
				+" a.overdraft, a.accountType, c.name, c.ssn, c.phone, a.regDate"
				+ " FROM Account a INNER JOIN Customer c ON a.customerId = c.cid"
				+ " WHERE c.ssn = ?";
		List<Account> list = new ArrayList<>();
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = DataSourceManager.getConnetion();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, ssn);
				rs = pstmt.executeQuery();
				Account account = null;
				
				while(rs.next()) {
					if (rs.getString("accountType").charAt(0) == 'S') {
						account = new SavingsAccount(sql,0);
						((SavingsAccount)account).setInterestRate(
								rs.getDouble("interestRate"));
					}else {
						account = new CheckingAccount();
						((CheckingAccount)account).setOverdraftAmount(
								rs.getDouble("overdraft"));
					}
					account.setAid(rs.getLong("aid"));
					account.setAccountNum(rs.getString("accountNum"));
					account.setBalance(rs.getDouble("balance"));
					account.setCustomer(new Customer(rs.getString("name"),
							rs.getString("ssn"), rs.getString("phone")));
					account.setRegDate(rs.getTimestamp("regDate"));
					list.add(account);	
				}
			}finally {
				DataSourceManager.close(rs,pstmt,con);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 입금하기, 계좌번호로 계좌찾기
	 * @param accountNum
	 * @return
	 */
	public Account findAccountsByAccountNum(String accountNum) {
		String sql = "SELECT * FROM Account WHERE accountNum = ?";
		Account account = null;
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = DataSourceManager.getConnetion();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, accountNum);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					if (rs.getString("accountType").charAt(0) == 'S') {
						account = new SavingsAccount();
						((SavingsAccount)account).setInterestRate(
								rs.getDouble("interestRate"));
						((SavingsAccount)account).setAccountType('S');
					}else {
						account = new CheckingAccount();
						((CheckingAccount)account).setOverdraftAmount(
								rs.getDouble("overdraft"));
						((SavingsAccount)account).setAccountType('C');
					}
					account.setAid(rs.getLong("aid"));
					account.setAccountNum(rs.getString("accountNum"));
					account.setBalance(rs.getDouble("balance"));
					account.setRegDate(rs.getTimestamp("regDate"));	
				}
			}finally {
				DataSourceManager.close(rs,pstmt,con);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}
	
	public void updateAccount(Account account, String accountNum) {
		String sql = "UPDATE Account SET balance = ?, overdraft = ? WHERE accountNum = ?";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DataSourceManager.getConnetion();
				pstmt = con.prepareStatement(sql);

				if (account.getAccountType() == 'S') {
					pstmt.setDouble(1, account.getBalance());
					pstmt.setDouble(2, 0.0);
					pstmt.setString(3, accountNum);
					
				}else {
					pstmt.setDouble(1, account.getBalance());
					pstmt.setDouble(2, ((CheckingAccount)account).getOverdraftAmont());
					pstmt.setString(3, accountNum);
				}
				pstmt.executeUpdate();
			}finally {
				DataSourceManager.close(pstmt,con);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
