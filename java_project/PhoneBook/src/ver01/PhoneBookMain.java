package ver01;

public class PhoneBookMain {

	public static void main(String[] args) {
		
		PhoneInfor pi1 = new PhoneInfor("홍길동","010-1111-2222", "19901031");
		pi1.showInfor(); // 참조변수 pi1이 가리키는 PhoneInfor 타입 객체
		
	    PhoneInfor pi2 = new PhoneInfor("최혜인", "010-2222-3333");
	    pi2.showInfor(); 
		
		
		
		
		

	}

}
