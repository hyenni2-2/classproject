package join.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import join.Join;

public class JoinDao {
	
	// 싱글톤패턴으로 만들기. 외부에서 수정하지 못하게
	private JoinDao() {}
	
	// 사용하기 위한 객체 하나 생성해두기.
	private static JoinDao dao = new JoinDao();
	
	// 외부에서 쓸 수 있게 하는 메서드 만들기.
	public static JoinDao getInstance() {
		return dao;
	}
	
	// sql문 입력 : connection 객체와 join을 매개변수로 받아야 한다.
	public int insertJoin(Connection conn, Join join) {
		int joinCnt = 0;
		PreparedStatement pstmt = null;
		
		String sqlInsert = "INSERT INTO join (joinid,pw,joinname,joinphoto) VALUES(?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sqlInsert);
			pstmt.setString(1, join.getJoinId());
			pstmt.setString(2, join.getPw());
			pstmt.setString(3, join.getJoinName());
			pstmt.setString(4, join.getJoinPhoto());
	
			joinCnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return joinCnt;
	}
	
	// sql 선택 : 
	
	

}
