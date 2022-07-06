package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//ncs 문제
public class ABCDao {
	private static String sql;
	private static Connection con = null;
	
	public ABCDao {
		try {
			con = ConnectionManager.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void doSomething() {
		try {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
			} finally {
				rs.close();
				pstmt.close();
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
