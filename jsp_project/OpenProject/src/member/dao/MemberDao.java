package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import member.Member;

public class MemberDao {

	// 싱글톤 패턴 (객체를 여러개 만들 필요가 없기 때문) : 코딩 스타일
	// 외부에서 인스턴스를 생성하지 못한다.
	// 인스턴스를 반환해주는 메서드가 있어서 인스턴스가 필요한 경우 메서드를 이용해서 얻는다.

	// 인스턴스 생성을 막는다 : 생성자의 접근제어자 -> private
	private MemberDao() {
	}

	// 객체 하나를 생성해서 사용한다(memberReg에서 memberDao를 갖다쓸 수 없기 때문)
	private static MemberDao dao = new MemberDao();

	// Dao 객체의 참조변수를 반환해주는 메서드가 필요(private으로 선언했기 때문) : 누구나 사용이 가능해야 함.
	public static MemberDao getInstance() {
		return dao;
	}

	// Member 테이블의 Data를 CRUD
	// insert, select, update, delete

	// 데이터 입력
	public int insertMember(Connection conn, Member member) {

		int resultCnt = 0;

		PreparedStatement pstmt = null;

		String sqlInsert = "INSERT INTO Member (memberid,password,membername) VALUES (?,?,?)";

		try {
			pstmt = conn.prepareStatement(sqlInsert); // 위 sql문을 만들어서 변수로 선언.
			pstmt.setString(1, member.getUserId()); // 매개변수로 전달받은 member를 각각 넣음
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getUserName());

			resultCnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultCnt; // executeUpdate는 int 타입으로 반환하기에 Cnt로 받아줘야 함
	}

	// 로그인을 위한 select 한 결과 : 객체로 반환해주면 되므로 Member타입으로 선언
	public Member selectMemberLogin(Connection conn, String uid, String pw) {

		Member member = null;

		String sqlSelect = "select * from open.Member where memberid =? and password=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sqlSelect);
			pstmt.setString(1, uid);
			pstmt.setString(2, pw);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				member = new Member(rs.getString("memberid"), rs.getString("password"), rs.getString("membername"),
						rs.getString("memberphoto"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}

}
