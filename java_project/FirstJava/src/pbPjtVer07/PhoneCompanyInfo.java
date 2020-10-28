package pbPjtVer07;

public class PhoneCompanyInfo extends PhoneInfo {
    
	private String company;
	
	// 생성자
	public PhoneCompanyInfo(String name, String num, String addr, String email, String company) {
		super(name, num, addr, email);
		this.company=company;
	}

	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("회사 : " + company);
	}

	@Override
	public void showBasicInfo() {
		System.out.println("이름 : " + getName());
		System.out.println("메일 : " + getEmail());
	}
	
	
	
	 
	

}
