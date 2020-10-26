package pbPjtVer07;

import java.io.Serializable;

public class PhoneInfo07 implements Serializable {
	private String name;
	private String phoneNumber;
	private String address;
	private String email;
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}

	
	//생성자 만들기
	public PhoneInfo07(String name, String num, String addr, String email){
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


	
	public void showBasicInfo() {
		
	}
	
}
