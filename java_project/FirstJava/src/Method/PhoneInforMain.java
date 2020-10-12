package Method;

public class PhoneInforMain {

	public static void main(String[] args) {
		
		PhoneInfor info = new PhoneInfor();    // 참조변수 선언
		
		info.phoneInfo("홍길동", "010-2345-6789", "19901031");     // string 타입이니까 잊지 말고 "" 붙이기
		
		info.phoneInfo2("최혜인", "010-2141-2222");
		
	
		
		System.out.println("현재 저장된 전화번호부");      // 저장된 정보를 출력하는 메소드를 입력하기
		info.showInfoResult();
		
		
		

	}

}
