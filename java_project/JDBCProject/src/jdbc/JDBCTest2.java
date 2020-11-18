package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCTest2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Connection conn = null;
		
		try {
			// 1) 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2) 데이터베이스 연결
			String DbUrl = "JDBC:oracle:thin:@localhost:1521:orcl";
			String DbUser = "scott";
			String DbPw = "tiger";
			conn = DriverManager.getConnection(DbUrl, DbUser, DbPw);
			System.out.println("DB 접속 완료!");
			
			String sql = "select * from emp order by deptno";
            PreparedStatement pstmt = conn.prepareStatement(sql);
			
// 2.EMP 테이블의 모든 데이터를 출력하는 프로그램을 작성해보자.
			
			ResultSet rs = pstmt.executeQuery(sql);
			
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				String hiredate = rs.getString("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				System.out.println
				(empno+"\t"+ename+"\t"+job+"\t"+mgr+"\t"+hiredate+"\t"+sal+"\t"+comm+"\t"+deptno);
			}
			rs.close();
			pstmt.close();
			conn.close();
			

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("DB 연결 중 오류 발생"+e.getMessage());
			e.printStackTrace();
	


	}

	}
}
