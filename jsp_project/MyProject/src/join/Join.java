package join;

public class Join {
	
	private String joinId;
	private String pw;
	private String joinName;
	private String joinPhoto;
	
	public Join() {}
	
	public Join(String joinId, String pw, String joinName, String joinPhoto) {
		this.joinId = joinId;
		this.pw = pw;
		this.joinName = joinName;
		this.joinPhoto = joinPhoto;
	}
	
	public String getJoinId() {
		return joinId;
	}
	public void setJoinId(String joinId) {
		this.joinId = joinId;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getJoinName() {
		return joinName;
	}
	public void setJoinName(String joinName) {
		this.joinName = joinName;
	}
	public String getJoinPhoto() {
		return joinPhoto;
	}
	public void setJoinPhoto(String joinPhoto) {
		this.joinPhoto = joinPhoto;
	}
	
	@Override
	public String toString() {
		return "join [joinId=" + joinId + ", pw=" + pw + ", joinName=" + joinName + ", joinPhoto=" + joinPhoto + "]";
	}

}
