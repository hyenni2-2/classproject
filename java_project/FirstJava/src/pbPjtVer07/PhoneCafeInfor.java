package pbPjtVer07;

public class PhoneCafeInfor extends PhoneInfo07 {
    private String cafe;
	
	public PhoneCafeInfor(String name, String num, String addr, String email, String cafe) {
		super(name, num, addr, email);
		this.cafe=cafe;
	}

	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("동호회 : " + cafe);
	}

	@Override
	public void showBasicInfo() {
		System.out.println("이름 : " + getName());
		System.out.println("메일 : " + getEmail());
	}
	
	

}
