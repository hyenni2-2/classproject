package pbPjtVer07;

public abstract class PhoneInfo implements PhoneInfoVer05 {
	private String name;
	private String phoneNumber;
	private String address;
	private String email;

	
	// 변수가 캡슐화되어 있으므로, 변수를 불러오기 위한 getter 설정
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	
	//생성자 만들기
	PhoneInfo(String name, String num, String addr, String email){
		this.name=name;
		this.phoneNumber=num;
		this.address=addr;
		this.email=email;
	}
   
	// 오버라이딩 처리하기
	public void showInfo() {
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phoneNumber);
		System.out.println("주소 : " + address);
		System.out.println("이메일 : " + email);
		
	}


	
	//오버라이딩 처리 - 자손클래스에서 이용 -> 추상화 한 이유: 오버라이딩을 위한 메서드이기 때문에.
	public abstract void showBasicInfo();
//	public void showBasicInfo() {
//		
//	}
	
}
