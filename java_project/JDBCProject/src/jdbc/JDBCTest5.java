package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCTest5 {

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

//			5.모든 사원정보를 출력하되 부서정보를 함께 출력하는 프로그램을 작성해보자.			
			String sql = "select * from emp e, dept d where e.deptno=d.deptno";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery(sql);

			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				String hiredate = rs.getString("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				System.out.println(empno + "\t" + ename + "\t" + job + "\t" + mgr + "\t" + hiredate.substring(0,10) + "\t" + sal + "\t"
						+ comm + "\t" + deptno);   // hiredate가 date타입으로 저장되어서 없애기 위해서는 substring을 추가해놔야함!
			}
			rs.close();
			pstmt.close();
			conn.close();


		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("DB 연결 중 오류 발생" + e.getMessage());
			e.printStackTrace();

		}

	}
}
