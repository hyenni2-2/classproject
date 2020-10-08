package Method;

public class PhoneInfor {
    // 데이터 선언 (저장에 필요한)
	String name;                // 이름 
	String phoneNumber;         // 전화번호 
	String birthday;           // 생년월일
	
	// 저장할 기능(메서드) 정의
	
	void phoneInfo(String myName, String phoneNum, String bd) {
		name = myName;           // 항상 매개변수를 필드에 대입해야 한다.!!! 반대로 하면 에러남
		phoneNumber = phoneNum;
		birthday = bd;	
		
	}
	
	// 출력할 기능 정의
	void showInfoResult() {
		System.out.print("이름 : " + name);
		System.out.print("\t전화번호 : " + phoneNumber);
		System.out.print("\t생년월일 : " + birthday);
		
	}
	
	
	
	
	
}
