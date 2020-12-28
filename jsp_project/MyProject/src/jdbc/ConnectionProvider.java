package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// SQL 안의 스키마에 연결시키기 위한 클래스
public class ConnectionProvider {
	
	public static Connection getConneciton() {
		
		Connection conn = null;
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/open?serverTimezone=UTC";
		String user = "aia";
		String password = "aia";
		
		try {
			conn = DriverManager.getConnection(jdbcUrl,user,password);
		} catch (SQLException e) {
			System.out.println("Connection 연결 실패");
			e.printStackTrace();
		}
		return conn;	
	}

}
