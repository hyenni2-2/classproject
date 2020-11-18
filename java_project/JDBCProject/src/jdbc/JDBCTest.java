package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCTest {

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
			
			// 1.EMP 테이블에 새로운 사원 정보를 입력하는 프로그램을 작성해보자.			
			
			System.out.println("이름을 입력하세요 > ");
			String name = sc.nextLine();
			System.out.println("직종을 입력하세요 > ");
			String job = sc.nextLine();
			System.out.println("매니저 사번을 입력하세요 > ");
			int mgr = sc.nextInt();
			sc.nextLine();
			System.out.println("입사일을 입력하세요 > ");
			String hireDate = sc.nextLine();
			System.out.println("월급을 입력하세요 > ");
			int sal = sc.nextInt();
			System.out.println("커미션을 입력하세요 > ");
			int comm = sc.nextInt();
			System.out.println("부서 번호를 입력하세요 > ");
			int deptno = sc.nextInt();
			
			String insertSql = 
			"insert into emp values(seq_emp_empno.nextval,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(insertSql);

			
			pstmt.setString(1, name);
			pstmt.setString(2, job);
			pstmt.setInt(3, mgr);
			pstmt.setString(4, hireDate);
			pstmt.setInt(5, sal);
			pstmt.setInt(6, comm);
			pstmt.setInt(7, deptno);
			
			int insertCnt = pstmt.executeUpdate();
			if(insertCnt>0) {
				System.out.println(insertCnt+"개 정보가 저장되었습니다.");
			}
			
			pstmt.close();
			conn.close();

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("DB 연결 중 오류 발생"+e.getMessage());
			e.printStackTrace();

	}

	}
}
