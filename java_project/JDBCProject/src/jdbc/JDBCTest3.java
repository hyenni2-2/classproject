package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCTest3 {

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
			
			String sql = "update emp set sal=1000 where ename='SCOTT'";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            
//    		3. EMP 테이블에 서 “SCOTT” 사원의 급여(sal) 정보를 1000으로 바꾸는 프로그램을 작성해보자.
            int result = pstmt.executeUpdate(sql);

  
            pstmt.close();
            
            
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("DB 연결 중 오류 발생"+e.getMessage());
			e.printStackTrace();
//		4.EMP 테이블에 서 “SCOTT” 이름으로 검색한 결과를 출력하는 프로그램을 작성해보자.

//		5.모든 사원정보를 출력하되 부서정보를 함께 출력하는 프로그램을 작성해보자.
		


	}

	}
}
