
public class LoginData {

	private String memId;
	private String pw;
	
	public LoginData() {
		
	}
	
	public LoginData(String memId, String pw) {
		this.memId = memId;
		this.pw = pw;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "loginData [memId=" + memId + ", pw=" + pw + "]";
	}
	
}
