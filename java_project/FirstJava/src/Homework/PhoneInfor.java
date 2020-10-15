package Homework;

public class PhoneInfor {
	
//	Version 0.1 전화번호 관리 프로그램. 
//	PhoneInfor 라는 이름의 클래스를 정의해 보자. 클래스는 다음의 데이터들의 문자열 형태로 저장이 가능 해야 하며, 저장된 데이터의 적절한 출력이 가능하도록 메소드 정의
//	• 이름            name              String
//	• 전화번호       phoneNumber     String
//	• 생년월일       birthday            String 
//	단, 생년월일 정보는 저장할 수도 있고, 저장 않을 수도 있게끔 생성자 생성.
	
// 2020.10.15 처음에 생성자를 만들지 않고 void 타입으로 다 선언했었으나, 그렇게 하니 ver03의 클래스와 연결이 되지 않는 문제가 발생.
// void라 리턴값이 없어서. 따라서 다시 수정하여 생성자를 만들어 놓았음.
	
	String name;
	String phoneNumber;
	String birthday;
	
	PhoneInfor(String name, String phoneNumber, String birthday) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}
	
	PhoneInfor(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		birthday = null;
	}
	
	
	void showData() {
		if(birthday==null) {
			System.out.println("이름 : " + name + " 전화번호 : " + phoneNumber);
		} else {
			System.out.println("이름 : " + name + " 전화번호 : " + phoneNumber +" 생년월일 : " + birthday);
		}
	}

}
