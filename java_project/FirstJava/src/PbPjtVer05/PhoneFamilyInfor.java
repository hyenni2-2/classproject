package PbPjtVer05;

public class PhoneFamilyInfor extends PhoneInfo {
	
	private int family;

	public PhoneFamilyInfor(String name, String num, String addr, String email, int family) {
		super(name,num,addr,email);
		this.family=family;
	}

	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("가족 수 : " + family);
	}

	@Override
	public void showBasicInfo() {
		System.out.println("이름 : " + getName());
		System.out.println("메일 : " + getEmail());
	}
	
	

}
