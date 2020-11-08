package NameBook;

public class NameBookInfo implements Util {
	// 전화번호부 인포 만들기
	
	// 변수 선언하기
	private String name;
    private String phoneNumber;
    private String address;
    private String email;
    
    
    
    
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public NameBookInfo() {
		
	}

	public NameBookInfo(String name, String phoneNumber, String address, String email) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
	}
	
	// 생성자는 중복 생성이 가능하니까, 추가로 생성할 수 있음.(컴퍼니인포용으로 작)
	public NameBookInfo(String name, String phoneNumber, String email) {
		this.name=name;
		this.phoneNumber=phoneNumber;
		this.email=email;
	}
	
	
	void showAll() {
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phoneNumber);
		System.out.println("주소 : " + address);
		System.out.println("이메일 : " + email);
		
	}
	
    void showPart() {
    	System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phoneNumber);
		System.out.println("이메일 : " + email);
    }

	
	
}
