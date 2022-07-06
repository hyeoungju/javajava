package jv251.varxyz.jv251.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DataSourceManager { //final 은 선언과 동시에 초기화해야함, 최소한 생성자에서 해줘야함 객체를 만들기 전에
	private static final String JDBC_URL;
	private static final String JDBC_USER;
	private static final String JDBC_PASSWD;
	//static initialize를 사용하면 초기화 안해도 된다
	
	static { //static initialize, 이런걸 보관하는 곳이 file(외부파일) 이다.
		//보안 이슈로 저장하는것, 실리적인 문제, 만약에 저게 바뀌면 서버를 내리고 소스를 뒤져야 한다.
//		JDBC_URL = "";
//		JDBC_USER = "";
//		JDBC_PASSWD = "";
//		JDBC_ID = "";
		Properties props = new Properties();
		try {
			props.load(new FileInputStream("jdbc.properties"));			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
		try {
			Class.forName(props.getProperty("JDBC_DRIVER"));
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		JDBC_URL = props.getProperty("JDBC_URL");
		JDBC_USER = props.getProperty("JDBC_USER");
		JDBC_PASSWD = props.getProperty("JDBC_PASSWD");
		
		System.out.println("JDBC_PASSWD = " + JDBC_PASSWD);
	}
	
	public static Connection getConnetion() throws SQLException {
		return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWD);
	}
	
	public static void main(String[] args) {
		DataSourceManager manager = new DataSourceManager();
	}
	
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if(rs != null) {
			rs.close();
		}
		if(pstmt != null) {
			pstmt.close();
		}
		if(con != null) {
			con.close();
		}
	}
	
	//overloading
	public static void close(PreparedStatement pstmt, Connection con) throws SQLException {
		close(null, pstmt, con);
	}
	
}
