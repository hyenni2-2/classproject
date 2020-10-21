package PbPjtVer05;

public class PhoneUnivInfor extends PhoneInfo {
	private String major;
	private String year;
	
	// 생성자 만들어서 인스턴스 변수 초기화
	public PhoneUnivInfor(String name, String num, String addr, String email, String major, String year) {
		super(name,num,addr,email);
		this.major=major;
		this.year=year;
	}

	// 조상클래스 오버라이딩 하기
	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("전공 : " + major);
		System.out.println("학년 : " + year);
	}
	
    // 조상클래스 오버라이딩 하기
	@Override
	public void showBasicInfo() {
		System.out.println("이름 : " + getName());
		System.out.println("메일 : " + getEmail());		
	}
	
	
	

}
