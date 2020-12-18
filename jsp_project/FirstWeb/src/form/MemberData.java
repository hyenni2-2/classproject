package form;

public class MemberData {

	// 변수 선언하기
	private String userid; // 사용자 아이디
	private String pw; // 사용자 이름

	// 생성자 생성
	public MemberData() {

	}
	
	public MemberData(String userid, String pw) {
		this.userid = userid;
		this.pw = pw;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "MemberData [userid=" + userid + ", pw=" + pw + "]";
	}

}
