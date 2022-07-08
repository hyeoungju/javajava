package com.varxyz.jv300.mod011;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
	private Datasource dataSource;
	
	public UserDao() {
		NamingService ns = NamingService.getInstance();
		dataSource = (Datasource)ns.getAttribute("dataSource");
		
	}
			
	public void addUser(User user) {
		String sql = "INSERT INTO User(userId, passwd, userName,"
				+ "email, ssn, addr)"
				+ "VALUES(?,?,?,?,?,?)";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user.getUserId());;
				pstmt.setString(2, user.getPasswd());
				pstmt.setString(3, user.getUserName());
				pstmt.setString(4, user.getEmail());;
				pstmt.setString(5, user.getSsn());
				pstmt.setString(6, user.getAddr());
				pstmt.executeUpdate();
				System.out.println("NEW ACCOUNT INSERTED.....");
			}finally {
				dataSource.close(pstmt,con);	
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isValidUser(String userId, String passwd) {
		System.out.println(userId + ": "+passwd);
		String sql = "SELECT * FROM User WHERE userId = ? AND passwd = ?";
		boolean result = false;
		try { 
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, userId);
				pstmt.setString(2, passwd);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					result = true;
				}			
			}finally {
				dataSource.close(rs, pstmt, con);
			}		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
	
}
